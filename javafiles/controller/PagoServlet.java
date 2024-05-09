package controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import modelos.Carrito; 

public class PagoServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        //si el usuario quiere pagar en primer lugar debemos de hacer el login de este para que pueda pagar
        
        //si el usuario paga borro todo el carrito de la sesiión y lo mandamos a la página de inicio
        HttpSession session = request.getSession();
        Carrito carrito = (Carrito) session.getAttribute("carrito");
        if (carrito!= null) {
            carrito.removeCarrito();
        }
        session.removeAttribute("carrito");
        //lo mandamos a la pagina de inicio
        response.sendRedirect("index.html?PagoEfectuado=true");
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        // Incluir la página del carrito
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pago.jsp");
        dispatcher.include(request, response);
    }
    
}
