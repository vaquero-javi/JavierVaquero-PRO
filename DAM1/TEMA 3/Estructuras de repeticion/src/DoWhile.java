import java.util.Scanner;

public class DoWhile {
    static Scanner scanner =new Scanner(System.in);
    public static void main(String[] args) {
        //Es un bucle de repetición que se usa en caso de condiciones (true)
        //de 1 a n veces

        /*
            int numero;
            int i=0;
            do {
                System.out.println("Introduce un numero");
                numero = scanner.nextInt();
                i++;
            }while (numero!=0);
         */

        MenuIterativo();
    }
    public static void MenuIterativo(){
        int añadir=1;
        int borrar=2;
        int listar=3;
        int buscar=4;
        int salir=5;

        int i;

        do {
            System.out.println("1.OPCION AÑADIR");
            System.out.println("2.OPCION BORRAR");
            System.out.println("3.OPCION LISTAR");
            System.out.println("4.OPCION BUSCAR");
            System.out.println("5.SALIR");

            System.out.println("¿Qué quieres leer?");
            i=scanner.nextInt();
            if (añadir == i) {
                System.out.println("Ejecutando opcion'añadir' ");
            } else if (borrar == i) {
                System.out.println("Ejecuatando opcion 'borrar'");
            } else if (listar == i) {
                System.out.println("Ejecutando opcion 'listar'");
            } else if (buscar == i) {
                System.out.println("Ejecutando opcion 'buscar'");
            }
        }while (salir!=i);
        System.out.println("terminando programa.....");
    }
}
