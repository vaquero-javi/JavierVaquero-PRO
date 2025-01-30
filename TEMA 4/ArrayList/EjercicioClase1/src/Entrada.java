import java.util.Scanner;

public class Entrada {

    /*
    1. (Garaje) Desarrollar una aplicación para el control de un garaje. El funcionamiento de la aplicación
    será desde consola mediante un menú que permita acceder a las diferentes opciones. Para la aplicación
    tendremos que tener en cuenta las siguientes cosas:
        - Un coche está formado por los siguientes atributos: marca (string) modelo (string),
        coste reparacion (int), matricula (string).

    Las opciones de la aplicación serán las siguientes:

        1- Añadirá un coche al taller, pidiéndome todos los datos necesarios.
         No se pueden añadir dos coches con la misma matricula
        2- Listar coches
        3- Buscar coches: Se pedirá una matrícula y se mostrarán los datos del coche.
        4- Mostrar costes: Se mostrará el coste acumulado de todos los coches de la lista.
        5- Eliminar coche: Se pedirá una matrícula y se eliminará el coche de la lista
        6- Vaciar garaje: Eliminará todos los coches de la lista
     */

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Garaje garaje = new Garaje();
        System.out.println("Bienvenido a la app de gestión de de coches de Talleres Manolo");
        garaje.menu();



    }
}
