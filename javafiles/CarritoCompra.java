import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*; 

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

        //redirigimos de vuelta el usuario a la pagina index.html
        response.sendRedirect("index.html?itemAdded=true");

    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        // Incluir la página del carrito
        RequestDispatcher dispatcher = request.getRequestDispatcher("/carrito.jsp");
        dispatcher.include(request, response);
    }

}
