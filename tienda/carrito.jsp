<%@ page isELIgnored="false" %>
<%@page session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Carrito de Compras</title>
    <style>
        h2{
            text-align: center;
        }
        table {
            width: 50%;
            margin: 20px auto;
            text-align: center;
        }
        th, td {
            padding: 10px;
        }
        a {  
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff; 
            color: #fff; 
            text-decoration: none; 
            border: none; 
            border-radius: 5px;
            cursor: pointer; 
        }
        div{
            display: block;
            text-align: center;
        }
    </style>
</head>
<body>
    <h2>Carrito de Compras</h2>
    <form action="CarritoServlet" method="post">
        <input type="hidden" name="action" value="eliminar">
        <table border="1">
            <thead>
                <tr>
                    <th>Nombre</th>
                    <th>Cantidad</th>
                    <th>Importe Total</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            <tbody>
                <c:set var="total" value="0" />
                <c:forEach items="${carrito.getCarrito()}" var="item" varStatus="itemloop">
                    <c:set var="total" value="${total + item.getCantidad() * item.getPrice()}" />
                    <tr>
                        <td>${item.getName()}</td>
                        <td>
                            <c:out value="${item.getCantidad()}" />   
                        </td>
                        <td><fmt:formatNumber value="${item.getCantidad() * item.getPrice()}" maxFractionDigits="2" /></td>
                        <td><input type="checkbox" name="itemsAEliminar" value="${item.getName()}" /></td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="3"></td> <!-- celdas vacias -->
                    <td> 
                        <button type="submit">Eliminar</button>
                    </td>
                </tr>
            </tbody>
        <!-- Guardar el valor total del carrito en la sesión para poder mostrarlo en la ventana de pagar-->
        <c:set var="totalCarrito" value="${total}" scope="session" />
        </table>
    </form>
    <table border="1">
        <thead>
            <tr>
                <th>IMPORTE TOTAL</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td><fmt:formatNumber value="${total}" maxFractionDigits="2" /></td>
            </tr>
        </tbody>
    </table>
    <div>
        <a href='index.html'>Volver a la seleccion de CDs</a>
        <a href='PagoServlet'>Pagar</a>
    </div>
    
</body>
</html>