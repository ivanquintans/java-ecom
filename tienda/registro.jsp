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

        form {
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

        a {
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

        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h2>Register</h1>
    <form action="UserServlet" method="post">
        Email: <input type="text" name="email" value="${email}"><br>
        Password: <input type="password" name="password" value="${password}"><br>
        Tipo de Tarjeta: 
        <select name="creditType">
            <option value="paypal">PayPal</option>
            <option value="visa">Visa</option>
            <option value="mastercard">Mastercard</option>
        </select><br>
        Numero de Tarjeta: <input type="text" name="creditNumber"><br>
        <input type="submit" id= "register" value="Register">
        <input type="hidden" name="action" value="register">
    </form>
    <a href="PagoServlet">Volver a la caja</a>
</body>
</html>
