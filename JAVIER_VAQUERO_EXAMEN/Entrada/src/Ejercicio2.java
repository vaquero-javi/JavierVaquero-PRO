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

        boolean compMillares = (aleatorio%1000) && (millares%100);
        System.out.println(compMillares);
        boolean compCentenas = ((int)aleatorio%100) && ((int)millares%100);
        System.out.println(compCentenas);
        boolean compDecenas = ((int)aleatorio%10) && ((int)millares%100);
        System.out.println(compDecenas);
        boolean compUnnidades = ((int)aleatorio%1) && ((int)millares%100);
        System.out.println(compUnnidades);



    }
}
