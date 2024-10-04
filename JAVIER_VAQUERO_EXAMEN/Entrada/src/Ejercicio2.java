import java.util.Scanner;

public class Ejercicio2 {
    static Scanner escribirTeclado = new Scanner(System.in);
    public static void main(String[] args) {
        int aleatorio = (int) (Math.random()*9000+1000);
        System.out.println("Introduce un numero entre 1000 y 9999:");
        System.out.println("Introduce la unidad");
        int unidades = escribirTeclado.nextInt();
        System.out.println("Introduce la decena");
        int decenas = escribirTeclado.nextInt();
        System.out.println("Introduce la centena");
        int centenas = escribirTeclado.nextInt();
        System.out.println("Introduce el millar");
        int millares = escribirTeclado.nextInt();

        boolean compMillares = ((float)aleatorio%1000) && ((float)millares%100);
        System.out.println(compMillares);
        boolean compCentenas = ((float)aleatorio%100) && ((float)millares%100);
        System.out.println(compCentenas);
        boolean compDecenas = ((float)aleatorio%10) && ((float)millares%100);
        System.out.println(compDecenas);
        boolean compUnnidades = ((float)aleatorio%1) && ((float)millares%100);
        System.out.println(compUnnidades);



    }
}
