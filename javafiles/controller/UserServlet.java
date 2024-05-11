package controller;

import java.io.*;
import java.text.DecimalFormat;

import javax.servlet.*;
import javax.servlet.http.*;

import DAO.DAOOrders;
import DAO.DAOUsers;
import modelos.Carrito;
import modelos.Order;
import modelos.User; 

public class UserServlet extends HttpServlet{
    private DAOUsers dao = new DAOUsers(); // Instancia de la clase DAOUsers
    private DAOOrders daoOrders = new DAOOrders(); //instancia de la clase DAOOrders

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //selecionamos la accion que es para saber si venimos de register o de login
        String action = request.getParameter("action");

        if (action.equals("login")) {
             // Obtenemos los datos del formulario
            String userEmail = request.getParameter("email");
            String password = request.getParameter("password");
       
            // Llamar al método para verificar si el usuario está logueado
            boolean loggedIn = dao.userExists(userEmail, password);
        
            if (loggedIn) {
                // Si el usuario existe lo logueamos y lo guardamos en la sesión
                User user = new User(userEmail, password);
                user = dao.loginUser(user);
                if (user!= null) {
                     //guardamos el usuario en la sesión
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);
                }else {
                    System.out.println("Fallo a la hora de loguear el usuario en la base de datos");
                    HttpSession session = request.getSession();
                    session.setAttribute("error", "Error al iniciar sesión. Por favor, verifique sus credenciales.");
                    response.sendRedirect("login.jsp");
                    return;
                }
               
            } else {
                // Si el usuario no está logueado, redirigir a la página de registro con los datos prellenados
                request.setAttribute("email", userEmail);
                request.setAttribute("password",  password);
                request.getRequestDispatcher("registro.jsp").forward(request, response);
            }

        }else if (action.equals("register")){ //si viene del formulario de registro
            //obtenemos todos los datos para el registro
            String userEmail = request.getParameter("email");
            String password = request.getParameter("password");
            String creditType = request.getParameter("creditType");
            String cardnumber = request.getParameter("creditNumber");
            
            //añadimos el usuario a la base de datos
            User user = new User(userEmail, password, creditType, cardnumber);
            if (dao.addUser(user)==true){
                //guardamos en la sesion el usuario
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
            }else{
                System.out.println("Fallo a la hora de registrar el usuario en la base de datos");
                //dejamos al usurio en la ventana de registro otra vez con mensaje de error al jsp
                HttpSession session = request.getSession();
                session.setAttribute("error", "Error al registrar el usuario. Por favor, verifique sus credenciales.");
                response.sendRedirect("registro.jsp");
                return;
            }
    
        }

        HttpSession session = request.getSession();

        //en ambos casos antes de redirigir a la página de confirmación de la compra, es necesario guardar el pedido en la base de datos
        //creamos el objeto de la clase order
        User user = (User) session.getAttribute("user");
        // Obtener el valor total del carrito desde la sesión y convertirlo a float
        
        String totalCarritoStr = session.getAttribute("totalCarrito").toString();
        Float amountNoFormat = Float.parseFloat(totalCarritoStr);
        DecimalFormat format = new DecimalFormat("#.##");
        Float amount = Float.parseFloat(format.format(amountNoFormat));

        Order order = new Order(user.getEmail(),amount);
        daoOrders.addOrder(order); //añadimos el pedido a la base de datos

        //despues de esto realizamos la confirmación de la compra
        response.sendRedirect("confirmarCompra.jsp");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        // Incluir la página del carrito
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.include(request, response);
    }
    

}