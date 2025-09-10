import java.util.Scanner;  //sirve para luego cuando ejecutemos la maquina podamos escribir y dar valores 

public class EntradaTeclado {

    static Scanner lectorTeclado = new Scanner(System.in);


    public static void main(String[] args){
        //ejemplo para String
        String nombre; //si no le doy valor, su valor es ''null''
        System.out.println("Por favor introduce tu nombre");
        //el usuario introduzca el nombre por el teclado
        nombre = lectorTeclado.next(); //se pone .next porque es string
        System.out.println("Mi nombre es "+ nombre);

        //Mi nombre es (XXX) tengo XXX mido (XXX) y tengo experiencia trabajando (TRUE)
        int edad;
        System.out.println("Por favor introduce tus edad");
        edad=lectorTeclado.nextInt();

        float altura = lectorTeclado.nextFloat();
        System.out.println("Por favor intruduce tu altura");

        boolean trabajo;
        System.out.println("¿Has trabajado? True or False");
        trabajo=lectorTeclado.nextBoolean();

        System.out.println("Mi nombre es "+nombre+" tengo "+edad+" ,mido "+altura+" y " +
                "" +
                "tengo experiencia trabajando? " +trabajo);

        


    }
}
