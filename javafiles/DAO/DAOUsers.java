package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelos.User;

public class DAOUsers {
    private static final String nombre_tabla = "users";

    //añadimos un usuario a la base de datos
    public boolean addUser(User user) {
        //intentamos la conexión con la base de datos
        String email = user.getEmail();
        String password = user.getPassword();
        Integer cardnumber = user.getCardNumber();
        String creditType = user.getCardType();

        try (Connection conexion = ConnectionManager.getConnection()) {

            // Verificamos si ya existe un usuario con ese email y esa contraseña
            if (userExists(email,password)) {
                System.out.println("El email y la contraseñas introducidos ya existen en la base de datos.");
                return false;
            }
           // Creamos la consulta SQL parametrizada
            String sql = "INSERT INTO " + nombre_tabla + " (email, contraseña, numero_tarjeta, tipo_tarjeta)" +
            " VALUES (?, ? , ?, ?)";
            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                // Establecemos los parámetros de la consulta
                stmt.setString(1, email);
                stmt.setString(2, password);
                stmt.setInt(3, cardnumber);
                stmt.setString(4, creditType);

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


    //Metodo que devuelve un usuario al hacer login

    public User loginUser(User user) {
        //obtenemos el email y la contraeña

        String email = user.getEmail();
        String password = user.getPassword();
        

         //intentamos la conexión con la base de datos
         try (Connection conexion = ConnectionManager.getConnection()) {
           // Creamos la consulta SQL parametrizada para evitar posibles ataques de inyección SQL
            String sql = "SELECT * FROM " + nombre_tabla + " WHERE email = ? AND contraseña = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                stmt.setString(1, email);
                stmt.setString(2, password);
                
                // Ejecutamos la consulta
                ResultSet rs = stmt.executeQuery();
                // Si se encuentra algún resultado
                if (rs.next()) {
                    // Obtenemos los valores de pago del usuario y se los asignamos
                    String creditType = rs.getString("tipo_tarjeta");
                    Integer cardnumber = rs.getInt("numero_tarjeta");

                    //asignamos los valores al usuario
                    user.setCardNumber(cardnumber);
                    user.setCardType(creditType);
                    return user;
                }
            }
    
        } catch (SQLException e) {
            System.err.println("Error en la ejecución de la sentencia" + e.getMessage());
            e.printStackTrace();
        }
        return null;
       
    }

    // Método que comprueba si existe un  usuario en la base de datos
    public boolean userExists(String userEmail, String password){
         //intentamos la conexión con la base de datos
         try (Connection conexion = ConnectionManager.getConnection()) {
            String sql = "SELECT COUNT(*) AS total FROM " + nombre_tabla + " WHERE user_email = ? AND user_password = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                stmt.setString(1, userEmail);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    int total = rs.getInt("total");
                    //si el total es mayor que 0, el usuario existe
                    return total > 0;
                }
            }
        
        } catch (SQLException e) {
            System.err.println("Error en la ejecución de la sentencia" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

}

    

