import java.util.Scanner;

public class Ejercicio3 {
    static Scanner escribirTeclado = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("¿Qué café quieres? espresso, latte o capuchino");
        String cafe = escribirTeclado.next();
        System.out.println("¿Cuanto azucar quieres?");
        int azucar= escribirTeclado.nextInt();
        System.out.println("¿Que tamaño quieres? grande, mediano o pequeño");
        String tamaño = escribirTeclado.next();

        System.out.printf("Preparando un %s de tamaño %s con %d cucharaditas de azucar",cafe,tamaño,azucar);
    }
}
