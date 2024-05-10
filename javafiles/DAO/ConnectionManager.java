package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    public static Connection getConnection() {
        Connection connection = null;

        // Cargamos el driver de PostgreSQL	
        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL JDBC Driver not found");
            e.printStackTrace();
        }

        // Creamos la conexión con la base de datos
        String url = "jdbc:postgresql://postgres-db:5432/tienda";
        String user = "www-data";
        String password = "tienda";
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.err.println("Conexion NO establecida con " + url);
            e.printStackTrace();
        }

        return connection;
    }
}
