import Controller.GestorProductos;
import Model.Productos;

import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorProductos gestorProductos = new GestorProductos();
        Productos productos = new Productos();
        int menu;
        do {
            System.out.println("1.Importa todos los productos");
            System.out.println("2.Crear varios productos");
            System.out.println("3.Leer la información de un producto dado su ID");
            System.out.println("4.Actualizar la información de un producto dado su ID");
            System.out.println("5.Eliminar un producto dado su ID");
            System.out.println("6.Muestra todos los productos de la tabla");
            System.out.println("7.Salir del menú");
            menu = scanner.nextInt();

            switch (menu){
                case 1:

                    break;

                case 2:
                    System.out.println("Introduce el producto que quieres crear");
                    gestorProductos.insertarProducto(productos);
                    break;

                case 3:
                    System.out.println("Introduce el ID del prodcuto para saber su información");
                    int id1 = scanner.nextInt();
                    gestorProductos.obtenerProductoByID(id1);
                    break;

                case 4:
                    System.out.println("Introduce el ID del producto que quieras actualizar");
                    int id2 = scanner.nextInt();
                    break;

                case 5:
                    System.out.println("Introduce el ID del producto que quieres eliminar");
                    int id3 = scanner.nextInt();
                    gestorProductos.borrarProductoByID(id3);
                    break;

                case 6:
                    System.out.println("A continuación se te mostrarán todos los prodcutos de la tabla");
                    gestorProductos.obtenerProducto(productos);
                    break;

                case 7:
                    System.out.println("Saliendo del menú...");
                    break;
            }

        }while (menu != 7);
    }
}
