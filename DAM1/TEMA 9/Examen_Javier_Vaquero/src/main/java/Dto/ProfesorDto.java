package Dto;

import Model.Profesor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfesorDto {
    private Connection connection;

    public void insertarProfesor(Profesor profesor){

        String query =String.format ("INSERT into profesores VALUES ? ");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
