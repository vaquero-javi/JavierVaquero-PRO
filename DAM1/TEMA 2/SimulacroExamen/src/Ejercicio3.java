import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
    Scanner escribirTeclado = new Scanner(System.in);
        System.out.println("¿Cual es el precio del coche?");
        int precioCoche = escribirTeclado.nextInt();
        System.out.println("¿En cuantos plazos (meses) lo vas a pagar?");
        int plazos = escribirTeclado.nextInt();
        float preioPlazos = precioCoche / plazos;
        System.out.printf("Vas a pagar el coche de %d€ en %d meses, con un total de %.2f€ cada plazo", precioCoche, plazos, preioPlazos);
    }
}
