import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*; 

public class CarritoCompra extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{

        //selecionamos la accion que es para saber si tenemos que eliminar o añadir
        String action = request.getParameter("action");

        // Obtenemos la sesion actual del usuario para que el carrito sea el adecuado y no se comparta
        HttpSession session = request.getSession();
        
        // si viene del formulario de eliminar
        if (action.equals("eliminar")) {

            Carrito carrito = (Carrito) session.getAttribute("carrito");
            
            //Obtenemos los valores provenientes de la checkbox
            String[] itemsAEliminar = request.getParameterValues("itemsAEliminar");

            //Eliminamos los elementos del carrito

            //itemsAEliminar contiene los nombres de los cds a eliminar
            if (itemsAEliminar != null && itemsAEliminar.length > 0) {
                for (String item : itemsAEliminar) {
                    carrito.removeItem(item); // Suponiendo que el método eliminarItem elimina el ítem del carrito en la posición especificada.
                }
            }
            //una vez eliminados los elementos,actualizamos el carrito en la sesion

            //cargamos de nuevo el jsp asociado

            response.sendRedirect("CarritoCompra");

        } else if (action.equals("anadir")) { // en caso de que venga del formulario de añadir

            // Pillamos los datos del cd seleccionado
            String currentCD = request.getParameter("cd");
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));

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
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        // Incluir la página del carrito
        RequestDispatcher dispatcher = request.getRequestDispatcher("/carrito.jsp");
        dispatcher.include(request, response);
    }

}
