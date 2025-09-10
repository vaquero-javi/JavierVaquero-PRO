package Controller;

import Dto.ProductosDto;
import Model.Productos;

import java.util.ArrayList;

public class GestorProductos {
    private ProductosDto productosDto;
    private ArrayList<Productos> listaProdcutos;

    public GestorProductos(){
        productosDto= new ProductosDto();
        listaProdcutos= new ArrayList<>();
    }

    public void insertarProducto(Productos productos){
        if (productos == null){
            System.out.println("Error! Este producto no se ha podido añadir");
        }else {
            productosDto.insertarProducto(productos);
            listaProdcutos.add(productos);
            System.out.println("Enhorabuena!Su producto se añadió con éxito");
        }
    }

    public void obtenerProducto(Productos productos){
        if (productos == null){
            System.out.println("Error! No se han podido obtener los productos");
        }else {
            productosDto.obtenerProductos(productos);
        }
    }

    public void obtenerProductoByID(int id){
        if (id == -1){
            System.out.println("Error! No se ha podido obtener el producto con el id");
        }else {
            productosDto.obtenerProductoByID(id);
        }
    }

    public void borrarProductoByID(int id){
        if (id == -1){
            System.out.println("Error! No se ha podido borrar el producto con el id");
        }else {
            productosDto.borrarProductoByID(id);
            listaProdcutos.remove(id);
        }
    }
    
}
