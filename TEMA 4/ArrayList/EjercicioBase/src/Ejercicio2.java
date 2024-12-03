import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Ejercicio2 {
    /*
    Crea un programa que cree un ArrayList con los nombres de todos los compañeros de clase. Una vez creado,
    sacará el nombre de uno de los compañeros (aleatorio)
     */

    private static ArrayList<String>nombresCompaneros = new ArrayList();
    private static Scanner scanner = new Scanner(System.in);
    private static int tamano=3;


    public static void main(String[] args) {

        for (int i = 0; i < tamano; i++) {
            System.out.println("Introduce el nombre de los compañeros de clase");
            anadirNombre(scanner.nextLine());
        }
        for (int i = 0; i < nombresCompaneros.size(); i++) {
            System.out.print(nombresCompaneros.get((int) (Math.random()*nombresCompaneros.size())));
        }

    }

    public static void anadirNombre(String nombre){
        nombresCompaneros.add(nombre);
    }
}
