import controller.Restaurante;
import model.Cliente;
import model.Consumiciones;

import java.util.ResourceBundle;
import java.util.Scanner;

public class Entrada {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        Consumiciones consumiciones = new Consumiciones();
        Restaurante restaurante = new Restaurante();
        int opcion;

        do {
            System.out.println("-------MENÚ-------");
            System.out.println("1. Admitir clientes");
            System.out.println("2. Agregar consumiciones a clientes");
            System.out.println("3. Muestra la lista de consumiciones de un cliente.");
            System.out.println("4. Imprime el total a pagar.");
            System.out.println("5. Ver total caja");
            System.out.println("6. Salir del menú");

            System.out.println("¿Introduce el número correspondiente a la opcion que quieres ver?");
            opcion= scanner.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("Introduce los siguientes datos para admitir a un cliente:");
                    System.out.println("Nombre");
                    cliente.setNombre(scanner.next());
                    System.out.println("Apellido");
                    cliente.setApellido(scanner.next());
                    System.out.println("DNI");
                    cliente.setDni(scanner.next());
                    break;
                case 2:
                    System.out.println("Introduce la consumicion que quieres tomar");
                    consumiciones.setNombre(scanner.next());
                    break;
                case 3:
                    System.out.println("Introduce tu dni para ver lo que has consumido");
                    cliente.setDni(scanner.next());
                    restaurante.mostrarInfo(cliente.getDni());
                    break;
                case 4:
                    System.out.println("Introduce tu dni para ver el total a pagar");
                    cliente.setDni(scanner.next());
                    restaurante.totalPagar(cliente.getDni());
                    break;
                case 5:
                    System.out.println("Facturación total");
                    restaurante.cajaTotal();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema....");
                    break;
            }

        }while (opcion!=6);
    }
}
