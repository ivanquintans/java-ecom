package controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import DAO.DAOOrders;
import DAO.DAOUsers;
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
            User user = new User(userEmail, password, creditType, Integer.parseInt(cardnumber));
            if (dao.addUser(user)==true){
                //guardamos en la sesion el usuario
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
            }else{
                System.out.println("Fallo a la hora de registrar el usuario en la base de datos");
                return;
            }
    
        }

        //en ambos casos antes de redirigir a la página de confirmación de la compra, es necesario guardar el pedido en la base de datos
        daoOrders.addOrder(, null)


        //despues de esto realizamos la confirmación de la compra
        response.sendRedirect("confirmar_compra.jsp");




       
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        // Incluir la página del carrito
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        dispatcher.include(request, response);
    }
    

}