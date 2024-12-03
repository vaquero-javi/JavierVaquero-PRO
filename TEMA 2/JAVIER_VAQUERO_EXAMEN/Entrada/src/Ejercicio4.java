import java.util.Scanner;

public class Ejercicio4 {
    static Scanner escreibirTeclado = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Introduce tu nombre y apellido");
        String nombre = escreibirTeclado.nextLine();
        System.out.println("¿Qué sueldo esperas percibir?");
        int sueldo = escreibirTeclado.nextInt();
        System.out.println("Dime tu edad");
        int edad= escreibirTeclado.nextInt();
        System.out.println("Dime el dia de tu cumpleaños");
        int diaCumple= escreibirTeclado.nextInt();
        System.out.println("¿Tienes carne de conducir?");
        String carne= escreibirTeclado.next();
        boolean valido = (edad<50)&&(sueldo<40000)&&(carne.equalsIgnoreCase("si")) || (edad>45)&&(sueldo<20000) &&(diaCumple%2==0);

        System.out.printf("Con los datos introducidos, el candidato cuyo nombre es %s tiene como resolucion: %b",nombre,valido);
    }
}
