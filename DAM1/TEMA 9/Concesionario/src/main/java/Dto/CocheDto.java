package Dto;

import DataBase.DBConnection;
import Model.Coche;

import java.sql.*;
import java.util.ArrayList;

public class CocheDto {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;

    public void insertarCoche(Coche coche){
        connection = DBConnection.getConnection();
        String query = String.format("INSERT into %s (%s,%s,%s) VALUES (?,?,?)", "coches","marca","modelo","matricula");
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, coche.getMarca());
            preparedStatement.setString(2, coche.getModelo());
            preparedStatement.setString(3, coche.getMatricula());
            preparedStatement.execute(); //sirve para ejecutar
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void getCoche(Coche coche){
        connection = DBConnection.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM coches");

            while (resultSet.next()){
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                String matricula = resultSet.getString("matricula");
                coche.mostrarDatos();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getCocheById(int id){
        connection = DBConnection.getConnection();

        String query = String.format("SELECT * FROM %s WHERE %s = ?","coches","id");

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                String matricula = resultSet.getString("matricula");

                Coche coche = new Coche(marca, modelo, matricula);
                coche.mostrarDatos();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener el coche por ID", e);
        }
    }

    public void deleteCocheByID(int id){
        connection = DBConnection.getConnection();

        String query = String.format("DELETE from %s WHERE %S = ?", "coches","id");

        try {
            preparedStatement= connection.prepareStatement(query);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id_coche = resultSet.getInt("id");
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                String matricula = resultSet.getString("matricula");

                System.out.println("Borrado con éxito");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Coche> pasarArrayList(){
        connection = DBConnection.getConnection();
        ArrayList<Coche> listacoches = new ArrayList<>();

        String query =  String.format("SELECT * from %s", "coches");

        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                String matricula = resultSet.getString("matricula");

                Coche coche = new Coche(marca, modelo, matricula);
                listacoches.add(coche);
                coche.mostrarDatos();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
