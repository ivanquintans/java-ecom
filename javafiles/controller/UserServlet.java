package controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import DAO.DAOUsers;
import modelos.User; 

public class UserServlet extends HttpServlet{
    private DAOUsers dao = new DAOUsers(); // Instancia tu clase DAOUsers

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Obtenemos los datos del formulario
        String userEmail = request.getParameter("email");
        String password = request.getParameter("password");

        // Llamar al método para verificar si el usuario está logueado
        boolean loggedIn = dao.userExists(userEmail, password);
        
        if (loggedIn) {

            // Si el usuario existe lo logueamos y lo guardamos en la sesión
            User user = new User(userEmail, password);
            user = dao.loginUser(user);
            //guardamos el usuario en la sesión
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            
            //despues de esto realizamos la confirmación de la compra
            response.sendRedirect("confirmar_compra.jsp");
        } else {
            // Si el usuario no está logueado, redirigir a la página de registro con los datos prellenados
            request.setAttribute("email", userEmail);
            request.setAttribute("password",  password);
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }

    }
    

}