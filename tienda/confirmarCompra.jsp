<%@ page isELIgnored="false" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Pago</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }
        input[type="text"],
        input[type="password"],
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
            font-size: 16px;
        }

        input[type="submit"] {
            width: 100%;
            background-color: #007bff;
            color: white;
            cursor: pointer;
        }

        input[type="text"]:focus,
        input[type="password"]:focus {
            outline: none;
            border-color: #007bff;
        }

        .info {
            margin-bottom: 20px;
        }

        .info label {
            font-weight: bold;
        }

        .info p {
            margin-top: 5px;
        }

        .checkout-link {
            display: block;
            text-align: center;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 20px;
        }

        .checkout-link:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Detalles del Pedido</h2>
        <div class="info">
            <label>Email:</label>
            <p><c:out value="${user.getEmail()}" /></p>
        </div>
        <div class="info">
            <label>Numero de Tarjeta:</label>
            <p><c:out value="${user.getCardNumber()}" /></p>
        </div>
        <div class="info">
            <label>Tipo de Tarjeta:</label>
            <p><c:out value="${user.getCardType()}" /></p>
        </div>
        <div class="info">
            <label>Total a Pagar:</label>
            <p><fmt:formatNumber value="${totalCarrito}" maxFractionDigits="2" /></p>
        </div>
        <form action="ConfirmarServlet" method="post">
            <!-- Aquí puedes agregar más campos si es necesario -->
            <input type="submit" value="Volver a la seleccion de CDs">
            <input type="hidden" name="action" value="pagar">
        </form>
    </div>
</body>
</html>

