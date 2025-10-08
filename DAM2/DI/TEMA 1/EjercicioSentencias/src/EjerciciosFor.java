import java.util.Scanner;

public class EjerciciosFor {
    Scanner scanner = new Scanner(System.in);

    //Ejercicio 1
    //Lee el número de temperaturas (si <= 0, usar 10). Calcula la media con dos decimales.
    public void mediaTemperaturas(){
        System.out.println("1. Lee el número de temperaturas (si <= 0, usar 10). Calcula la media con dos decimales.");
        System.out.println("Introduce el numero de temperatuas de las que quieras hacer la media");
        int num= scanner.nextInt();

        int temp = 0;
        int sumatemp = 0;
        int media = 0;

        for (int i = 0; i < num; i++) {
            System.out.println("Introduce las temperaturas ");
            temp = scanner.nextInt();
            sumatemp = sumatemp +  temp;
            media = sumatemp / num;
        }
        System.out.println("La media es: " + media);
    }

    //Ejercicio 2
    //Lee un número 0-10 y muestra su tabla del 0 al 10.
    public void tablaDeMultiplicar(){
        System.out.println("2. Lee un número 0-10 y muestra su tabla del 0 al 10.");
        System.out.println("Introduce un numero del 0-10 para mostrar su tabla de multiplicar");
        int numero = scanner.nextInt();
        int nummultiplicar = 0;
        for (int i = 0; i <= 10; i++) {
            int tabla = numero * nummultiplicar;
            System.out.println(numero + "x" + nummultiplicar + "=" + tabla);
            nummultiplicar++;
        }
    }

    //Ejercicio 3
    //Muestra las tablas de multiplicar de 0 a 10.
    public  void todasLasTablasDeMultiplicar(){
        System.out.println("3. Muestra las tablas de multiplicar de 0 a 10.");
        int numero = 0;
        int nummultiplicar = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                int tabla = numero * nummultiplicar;
                System.out.println(numero + "x" + nummultiplicar + "=" + tabla);
                if (nummultiplicar>= 0 && nummultiplicar <10){
                    nummultiplicar++;
                }else {
                    nummultiplicar = 0;
                }
            }
            numero++;
        }

    }


}
