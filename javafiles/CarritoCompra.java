import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;;

public class CarritoCompra extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{

        // Pillamos los datos del cd seleccionado
        String currentCD = request.getParameter("cd");
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
         
        // Obtenemos la sesion actual del usuario para que el carrito sea el adecuado y no se comparta
        HttpSession session = request.getSession();

        // Si el carrito existe, lo empleamos, en caso de que no exista lo creamos
        Carrito carrito = (Carrito) session.getAttribute("carrito");
        if (carrito == null) {
            carrito = new Carrito();
            session.setAttribute("carrito", carrito);
        }

        // Agregar el artículo al carrito de la compra
        carrito.addItem(currentCD, cantidad);

       // Imprimir el contenido del carrito en la salida del servlet
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Contenido del Carrito</title></head><body>");
        out.println("<h1>Contenido del Carrito</h1>");
        out.println("<ul>");
        for (Item item : carrito.getCarrito()) {
            out.println("<li>" + item.getName() + " (Cantidad: " + item.getCantidad() + ")</li>");
        }
        out.println("</ul>");
        out.println("<a href='index.html'>Volver al inicio</a>");
        out.println("</body></html>"); 


    } 


}
