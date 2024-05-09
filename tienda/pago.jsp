<%@ page isELIgnored="false" %>
<%@page session="true" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pago</title>
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
        a, #pago {  
            padding: 10px 20px;
            background-color: #007bff; 
            color: #fff; 
            text-decoration: none; 
            border: none; 
            border-radius: 5px;
            cursor: pointer; 
        }
    </style>
</head>
<body>
    <h2>Caja</h2> 
    <table border="1">
        <thead>
            <tr>
                <th>TOTAL A PAGAR</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <c:if test="${not empty totalCarrito}">
                    <td><fmt:formatNumber value="${totalCarrito}" maxFractionDigits="2" /></td>
                </c:if>
            </tr>
        </tbody>
    </table>
    <form action='PagoServlet' method='post'> 
        <center>
            <a href='CarritoServlet'>Volver al carrito</a>
            <input type='submit' id="pago" value='Pagar' />  
        </center>
    </form>
</body>
</html>