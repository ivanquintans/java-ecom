<%@ page isELIgnored="false" %>
<%@page session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
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
        a{  
            display: block;
            text-align: center;
        }
    </style>
</head>
<body>
    <h2>Carrito de Compras</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Nombre</th>
                <th>Cantidad</th>
                <th>Importe Total</th>
            </tr>
        </thead>
        <tbody>
            <c:set var="total" value="0" />
            <c:forEach items="${carrito.getCarrito()}" var="item">
                <c:set var="total" value="${total + item.getCantidad() * item.getPrice()}" />
                <tr>
                    <td>${item.getName()}</td>
                    <td>
                        <form action="actualizarCantidad" method="post">
                            <input type="submit" name="accion" value="-" /> <!-- Botón para disminuir la cantidad -->
                            <c:out value="${item.getCantidad()}" /> <!-- Mostrar la cantidad actual -->
                            <input type="submit" name="accion" value="+" /> <!-- Botón para aumentar la cantidad -->
                        </form> 
                    </td>
                    <td><fmt:formatNumber value="${item.getCantidad() * item.getPrice()}" maxFractionDigits="2" /></td>
                </tr>
            </c:forEach>
        </tbody>
    <!-- Guardar el valor total del carrito en la sesión para poder mostrarlo en la ventana de pagar-->
    <c:set var="totalCarrito" value="${total}" scope="session" />
    </table>
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
    <a href='index.html'>Volver a la seleccion de CDs</a>
</body>
</html>
