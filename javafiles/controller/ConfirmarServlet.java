package controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import modelos.Carrito; 

public class ConfirmarServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
    
        //despues de la confirmacion de la compra, borramos el carrito de la sesion, y los datos del usuario
        HttpSession session = request.getSession();
        Carrito carrito = (Carrito) session.getAttribute("carrito");
        if (carrito!= null) {
            carrito.removeCarrito();
        }
        session.removeAttribute("carrito");
        session.removeAttribute("user");
        //lo mandamos a la pagina de inicio
        response.sendRedirect("index.html?PagoEfectuado=true");
    }
 
}
