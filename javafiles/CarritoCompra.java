import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;;

public class CarritoCompra extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{

        String carritoHTML = "<html><head><title>Carrito de la compra</title></head><body>";
        carritoHTML += "<h1>Carrito de la compra</h1>";
        carritoHTML += "<ul>";
        carritoHTML += "</ul>";
        carritoHTML += "<a href=\"index.html\">Volver al inicio</a>";
        carritoHTML += "</body></html>";

         
        response.setContentType("text/html");

        
        PrintWriter out = response.getWriter();

        
        out.println(carritoHTML);


    }


}
