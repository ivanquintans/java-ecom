package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOOrders {
    private static final String nombre_tabla = "orders";

    //añadimos un order a la base de datos
    public boolean addOrder(String userEmail, Float orderAmount) {
        //intentamos la conexión con la base de datos
        try (Connection conexion = ConnectionManager.getConnection()) {
           // Creamos la consulta SQL parametrizada
            String sql = "INSERT INTO " + nombre_tabla + " (user_email, amount) VALUES (?, ?)";
            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                // Establecemos los parámetros de la consulta
                stmt.setString(1, userEmail);
                stmt.setFloat(2, orderAmount);
                // Ejecutamos la consulta
                int filasInsertadas = stmt.executeUpdate();
                // Comprobamos si se insertó correctamente
                if (filasInsertadas > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error en la ejecución de la sentencia" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }


    //Mostramos al usuario el valor del precio total de su pedido

    public Float showOrder(String email) { //con el email del usuario obtenemos el pedido con indice mas alto 
        Float orderamount = 0f;
         //intentamos la conexión con la base de datos
         try (Connection conexion = ConnectionManager.getConnection()) {
           // Creamos la consulta SQL parametrizada para evitar posibles ataques de inyección SQL
            String sql = "SELECT amount FROM " + nombre_tabla + " WHERE email = ? AND id = (SELECT MAX(id) FROM " + nombre_tabla + " WHERE email = ?)";
            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                stmt.setString(1, email);
                stmt.setString(2, email);
                
                // Ejecutamos la consulta
                ResultSet rs = stmt.executeQuery();
                // Si se encuentra algún resultado
                if (rs.next()) {
                    // Obtenemos el valor de amount de la fila
                    orderamount = rs.getFloat("amount");
                }
            }
    
        } catch (SQLException e) {
            System.err.println("Error en la ejecución de la sentencia" + e.getMessage());
            e.printStackTrace();
        }
        return orderamount;
       
    }
}
    
