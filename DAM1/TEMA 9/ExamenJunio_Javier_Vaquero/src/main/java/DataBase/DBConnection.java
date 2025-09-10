package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection(){
        if (connection == null){
            createConnection();
        }
        return connection;
    }

    private static void createConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ExamenJunio_Javier_Vaquero","root","123456789");
        } catch (SQLException e) {
            System.out.println("Error en la conexión");;
        }
    }


}