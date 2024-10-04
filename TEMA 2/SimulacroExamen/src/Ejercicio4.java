import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner escribirTeclado = new Scanner(System.in);
        int precioCoche = 30000;
        System.out.println("El precio del coche es: "+precioCoche);
        int plazos = 6;
        System.out.println("El plazo es de:"+plazos);
        final float INTERES =3.5F;
        float interes2= 3.5F;
        float precioPlazos = precioCoche / plazos;
        float precioInteres = precioCoche*(interes2 / 100);
        System.out.printf("El interés pagado %.2f en el primer mes es de %.2f\n", interes2,precioInteres);

        plazos--;
        interes2+=INTERES;
        precioCoche-=5000;
        precioInteres = precioCoche*(interes2 / 100);
        System.out.printf("El interés pagado %.2f en el primer mes es de %.2f\n", interes2,precioInteres);

        plazos--;
        interes2+=INTERES;
        precioCoche-=5000;
        precioInteres = precioCoche*(interes2 / 100);
        System.out.printf("El interés pagado %.2f en el primer mes es de %.2f\n", interes2,precioInteres);

        plazos--;
        interes2+=INTERES;
        precioCoche-=5000;
        precioInteres = precioCoche*(interes2 / 100);
        System.out.printf("El interés pagado %.2f en el primer mes es de %.2f\n", interes2,precioInteres);

        plazos--;
        interes2+=INTERES;
        precioCoche-=5000;
        precioInteres = precioCoche*(interes2 / 100);
        System.out.printf("El interés pagado %.2f en el primer mes es de %.2f\n", interes2,precioInteres);

        plazos--;
        interes2+=INTERES;
        precioCoche-=5000;
        precioInteres = precioCoche*(interes2 / 100);
        System.out.printf("El interés pagado %.2f en el primer mes es de %.2f\n", interes2,precioInteres);
    }
}

