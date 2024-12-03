import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio1 {
    /*
    1. Crea un ArrayList de String y realiza las siguientes acciones
        - Guarda manualmente 10 palabras
        - Imprime por pantalla todas las palabras del arraylist
     */

    private static ArrayList<String> listaPalabras = new ArrayList();
    private static int tamano = 10;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < tamano; i++) {
            System.out.println("Introduce una palabra");
            guardarPalabras(scanner.next());
        }
        System.out.println(listaPalabras);


    }

    public static void guardarPalabras(String palabra) {
        listaPalabras.add(palabra);
    }
}
