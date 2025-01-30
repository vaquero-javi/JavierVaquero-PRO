import controller.Restaurante;

import java.util.Scanner;

public class Entrada {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Restaurante restaurante = new Restaurante();

        System.out.println("Bienvenido a Restaurantes Pepi");

        System.out.println("Seleccione una opción:");
        System.out.println("1. Indique su nombre, numero de mesa y las consumiciones que desean tomar");
        System.out.println("2. Si desea realizar el pedido indique lo que desea tomar");
        System.out.println("3. Si desea ver las mesas ocupadas que hay en el restaurante");
        System.out.println("4. Si desea liberar su mesa indique su numero de mesa");
        System.out.println("5. Salir");


        int opcion;
        do {
            switch (opcion) {
                case 1:
                    System.out.println("Indique su nombre, numero de mesa y las consumiciones que desean tomar");
                    restaurante.asignarMesa(scanner.nextLine(), scanner.nextInt(), scanner.nextLine());
                    break;

                case 2:
                    System.out.println("Si desea realizar el pedido indique lo que desea tomar");
                    restaurante.realizarPedido(scanner.nextLine());
                    break;

                case 3:
                    System.out.println("Si desea ver las mesas ocupadas que hay en el restaurante");
                    restaurante.mostrarMesasOcupadas();
                    break;

                case 4:
                    System.out.println("Si desea liberar su mesa indique su numero de mesa");
                    restaurante.liberarMesas(scanner.nextInt());
                    break;

                case 5:
                    System.out.println("Gracias por utilizar el sistema de reservas, nos vemos pronto.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }
}
