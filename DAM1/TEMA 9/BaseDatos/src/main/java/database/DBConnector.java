package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static Connection connection;

    public static Connection getConnection(){

        if (connection==null){
            createConnection();
        }

        return connection;
    }

    public static void createConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario_ces","root","vaquero9!");
        } catch (SQLException e) {
            System.out.println("Error en la conexion");
            System.out.println(e.getMessage());
        }
    }
}
