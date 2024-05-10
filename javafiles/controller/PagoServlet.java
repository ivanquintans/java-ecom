package controller;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class PagoServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        // Incluir la página del carrito
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pago.jsp");
        dispatcher.include(request, response);
    }
    
}
