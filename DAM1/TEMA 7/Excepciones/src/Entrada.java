import java.io.IOException;
import java.util.Scanner;

public class Entrada {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

       /* String[] cosas = new String[]{"Dato1", "Dato2", "Dato3"};
        int numero1 = 2;
        int numero2 = 0;
        String nombre;

        System.out.println("A qué posicion quieres acceder");
        int posicion = scanner.nextInt();

        try {
            System.out.println(cosas[posicion]);
            int resutado = numero1 / numero2;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("El size es pequeño que la posicion indicada");
        } catch (ArithmeticException e){
            System.out.println("Error en la division entre 0");
        }finally { //optativo
            System.out.println("Terminando proceso");
        }

        System.out.println("Terminando el porgrama");

        //System.out.println("El numero de letras de tu nombre es "+nombre.length());

        */

        /*
        Operaciones operaciones = new Operaciones();
        try {
            operaciones.divisionEntre0(8);
        }catch (ArithmeticException e){
            System.out.println("Error");
        }

         */

        /*
        Operaciones operaciones = new Operaciones();
        try {
            operaciones.crearFichero("/cosa/raiz/dato/ejemplo.txt");
        } catch (IOException e) {
            System.out.println("Error en la ruta del fichero");
        }

         */

        Operaciones operaciones = new Operaciones();
        try {
            operaciones.lanzarExcepcion("dato");
        }catch (Exception e){
            System.out.println("error");
        }
    }
}
