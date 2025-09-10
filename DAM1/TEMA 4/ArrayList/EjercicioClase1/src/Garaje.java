import java.util.ArrayList;
import java.util.Scanner;

public class Garaje {
/*
    1. (Garaje) Desarrollar una aplicación para el control de un garaje. El funcionamiento de la aplicación
    será desde consola mediante un menú que permita acceder a las diferentes opciones. Para la aplicación
    tendremos que tener en cuenta las siguientes cosas:
        - Un coche está formado por los siguientes atributos: marca (string) modelo (string),
        coste reparacion (int), matricula (string).

    Las opciones de la aplicación serán las siguientes:

        - Añadirá un coche al taller, pidiéndome todos los datos necesarios.
         No se pueden añadir dos coches con la misma matricula
        - Listar coches
        - Buscar coches: Se pedirá una matrícula y se mostrarán los datos del coche.
        - Mostrar costes: Se mostrará el coste acumulado de todos los coches de la lista.
        - Eliminar coche: Se pedirá una matrícula y se eliminará el coche de la lista
        - Vaciar garaje: Eliminará todos los coches de la lista
     */

    static Scanner scanner = new Scanner(System.in);
    ArrayList<Object[]> listaCoches = new ArrayList<>();

    private void anadirCoche(String marca, String modelo, int costeReparacion, String matricula) {
        Object[] coche = new Object[]{marca, modelo, costeReparacion, matricula};
        if (!estaCoche(matricula)) {
            listaCoches.add(coche);
            System.out.println("Coche añadido al taller correctamente");
        } else {
            System.out.println("Error, esta matrícula ya está registrada");
        }
    }

    private boolean estaCoche(String matricula) {

        for (Object[] coche : listaCoches) {
            if (coche[3].equals(matricula)) {
                return true;
            }
        }
        return false;
    }

    private void listarCoches() {
        if (listaCoches.isEmpty()) {
            System.out.println("No hay coches que listar");
        } else {
            for (Object[] coche : listaCoches) {
                System.out.println(coche[0] + "-" + coche[1] + "-" + coche[3]);
            }
        }
    }

    private void buscarCoches(String matricula) {
        for (Object[] coche : listaCoches) {
            if (matricula == coche[3]) {
                System.out.println("Los datos del coche pedido son los siguientes"+listaCoches);
            }else {
                System.out.println("La matricula introducida no está en nuestro taller");
            }
        }
    }

    private void mostrarCosteCoches(int costeReparacion) {
        int contadorCoste = 0;
        for (Object[] coche : listaCoches) {
            if (costeReparacion == coche[2]) {
                contadorCoste += costeReparacion;
            }
        }
        System.out.println("El coste total de reparacion de los coches sería de: "+costeReparacion);
    }

    private void eliminarCoche(String matricula) {
        for (Object[] coche : listaCoches) {
            listaCoches.removeIf(matricula -> (matricula == coche[3]));

        }
        System.out.println("Eliminado el coche con la matricula "+matricula);
    }

    private void vaciarTaller() {
        listaCoches.clear();
        System.out.println("Eliminados todos los coches de forma correcta");
    }

    public void menu() {
        int opcion = 0;
        do {
            System.out.println("1-Añadir coche al taller");
            System.out.println("2-Listar coches");
            System.out.println("3-Buscar coches");
            System.out.println("4-Mostrar coches");
            System.out.println("5-Eliminar coche");
            System.out.println("6-Vaciar coche");
            System.out.println("7-Salir del menu");
            System.out.println("¿QUE QUIERES HACER?");
            opcion=scanner.nextInt();
            switch (opcion) {

                case 1:
                    anadirCoche(scanner.nextLine(), scanner.nextLine(), scanner.nextInt(), scanner.nextLine());
                    break;
                case 2:
                    listarCoches();
                    break;
                case 3:
                    buscarCoches(scanner.nextLine());
                    break;
                case 4:
                    mostrarCosteCoches(scanner.nextInt());
                    break;
                case 5:
                    eliminarCoche(scanner.nextLine());
                    break;
                case 6:
                    vaciarTaller();
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
            }
        } while (opcion != 7);
    }

}
