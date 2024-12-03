import java.util.Scanner;

public class Ejercicio1 {
    static Scanner escribirTeclado = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Introduce tu nombre y apellido");
        String id = escribirTeclado.nextLine();

        System.out.println("¿De cuanto dinero dispones para hacer la compra?");
        float dinero= escribirTeclado.nextFloat();

        System.out.println("¿Cuanto cuesta la play 5 sin IVA?");
        float play= escribirTeclado.nextFloat();

        System.out.println("¿Cuanto cuesta el Iphone 15 sin IVA?");
        float iphone = escribirTeclado.nextFloat();

        System.out.println("¿Cual es el IVA actual?");
        int IVA = escribirTeclado.nextInt();

        float playIVA= play+(play*((float) IVA/100));
        System.out.println("El precio de la play con Iva son: "+playIVA);
        float iphoneIVA= iphone+(iphone*((float) IVA/100));
        System.out.println("El precio del Iphone con Iva son: "+iphoneIVA);

        boolean comprarPlay= dinero>playIVA;
        System.out.println("Te puedes comprar la play: "+comprarPlay);

        boolean comprarIphone= dinero>iphoneIVA;
        System.out.println("Te puedes comprar el Iphone: "+comprarIphone);

        boolean comprarDos= (dinero > playIVA) && (dinero >iphoneIVA);
        System.out.println("Te puedes comprar las dos cosas: "+comprarDos);



    }
}
