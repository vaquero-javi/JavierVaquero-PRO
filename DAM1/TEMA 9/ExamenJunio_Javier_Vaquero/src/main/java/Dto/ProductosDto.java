package Dto;

import DataBase.DBConnection;
import Model.Productos;

import java.sql.*;
import java.util.ArrayList;

public class ProductosDto {
    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;

    public void  insertarProducto(Productos productos){
        connection = DBConnection.getConnection();
        String query = String.format("insert into %s (%s,%s,%s) values (?,?,?)",
                "productos","nombre","precio","cantidad");
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,productos.getNombre());
            preparedStatement.setDouble(1,productos.getPrecio());
            preparedStatement.setInt(1,productos.getCantidad());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void obtenerProductos(Productos productos){
        connection = DBConnection.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from prodcutos");
            while (resultSet.next()){
                String nombre = resultSet.getString("nombre");
                String precio = resultSet.getString("precio");
                String cantidad = resultSet.getString("cantidad");
            }
        } catch (SQLException e) {
            System.out.println("Error para obtener los productos");;
        }
    }

    public void obtenerProductoByID(int id){
        connection = DBConnection.getConnection();
        String query = String.format("select * from %s where %s = ?", "productos","id");
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String nombre = resultSet.getString("nombre");
                String precio = resultSet.getString("precio");
                String cantidad = resultSet.getString("cantidad");
            }
        } catch (SQLException e) {
            System.out.println("Error para obtener el producto con la id");;
        }
    }

    public void borrarProductoByID(int id){
        connection = DBConnection.getConnection();
        String query = String.format("delete from %s where %s = ?", "productos","id");
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String nombre = resultSet.getString("nombre");
                String precio = resultSet.getString("precio");
                String cantidad = resultSet.getString("cantidad");
            }
        } catch (SQLException e) {
            System.out.println("Error para borrar el producto con la id");;
        }
    }

    public ArrayList <Productos> pasarArraylist(){
        connection = DBConnection.getConnection();
        ArrayList<Productos> listaProductos = new ArrayList<>();
        String query = String.format("select * from %s","productos");
        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                String nombre = resultSet.getString("nombre");
                String precio = resultSet.getString("precio");
                String cantidad = resultSet.getString("cantidad");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
