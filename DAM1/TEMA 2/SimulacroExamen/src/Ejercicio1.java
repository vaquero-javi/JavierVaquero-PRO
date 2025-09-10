import java.util.Scanner;

public class Ejercicio1 {
    static Scanner escribirTeclado = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Introduce un nombre");
        String nombre = escribirTeclado.nextLine();
        System.out.println("Introduce un apellido");
        String apellido = escribirTeclado.nextLine();
        System.out.println("Introduce tu edad");
        int edad = escribirTeclado.nextInt();
        System.out.println("Introduce tu altura");
        float altura = escribirTeclado.nextFloat();
        System.out.println("Introduce tu peso");
        float peso = escribirTeclado.nextFloat();
        System.out.println("Introduce tu sexo (M o F)");
        String sexo = escribirTeclado.next();

        System.out.println("Voy a calcular tu IMC...");
        float imc = calculoIMC(peso,altura);
        System.out.printf("Hola %s tu IMC teniendo en cuenta tu altura de %.2f cm y" +
                " tu peso de %.2f kg, tiene un valor de %.2f", nombre, altura, peso, imc);
    }
    public static float calculoIMC (float peso, float altura){
        return(float) (peso/Math.pow(altura,2));

    }
}
