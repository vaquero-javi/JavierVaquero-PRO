import java.util.Scanner;

public class Entrada {
    static Scanner escribirTeclado = new Scanner(System.in);
    public static void main(String[] args) {
        //EjemploIF();
        //Ejercicio1();
        //Ejercicio2();
        Ejercicio3();
    }
    public static void EjemploIF(){
        int nota = 6;
        //if -> 0-10 -> nota correcta
        if (nota >= 0 && nota <= 10){
            System.out.println("La nota es correcta");
            //decido que tipo de nota es
            // ss -> 0-4.99
            // ap -> 5-6.99
            // nt -> 7-8.99
            // sb -> 9-9.99
            // mh -> 10
            if (nota < 5){
                System.out.println("ss");
            } else if (nota < 7) {
                System.out.println("ap");
            } else if (nota < 9) {
                System.out.println("nt");
            } else if (nota < 10) {
                System.out.println("sb");
            }else {
                System.out.println("mh");
            }
        }else {
            System.out.println("La nota no es correcta");
        }

        System.out.println("Terminando la ejecucion");
    }
    public static void Ejercicio1(){
        /*
        *Pedir por teclado un entero y guardarlo en una variable
        * llamada a. Comprobar si “a” es par. De serlo, se almacena
        * en la cadena “s” el texto “Es par”. Al final del bloque
        * mostrar el mensaje por pantalla
        * */
        System.out.println("Introduce un numero");
        int a = escribirTeclado.nextInt();
        String s = "Es impar";
        if (a % 2 == 0) {
            s= "Es par";
        }
            System.out.println(s);
    }
    public static void Ejercicio2(){
        /*
        * Pedir por teclado un entero y guardarlo en una variable
        * llamada a. Comprobar si “a” es par o menor que 10 o menor
        * que 100. De ser par, se incrementa en una unidad “a”; de no
        * ser par, si es menor que 10, se decrementa “a” en una unidad;
        * de no ser par, ni ser menor que 10, si es menor que 100, se
        * duplica el valor de “a” y se incrementa en una unidad; de no
        * ser par, ni menor que 10, ni menor que 100, entonces se le
        * asigna a “a” el valor de 0. Al final del bloque mostrar el
        * valor de la por pantalla
        * */
        System.out.println("Introduce un numero");
        int a = escribirTeclado.nextInt();
        if (a%2==0 || a<10 || a<100){
            if (a%2==0){
                a++;
            } else if (a<10) {
                a--;
            }else {
                a*=2;
                a++;
            }
        }else {
            a = 0;
        }
        System.out.println("El valor de a es "+a);
    }
    public static void Ejercicio3(){
        System.out.println("Introduce un numero");
        int a = escribirTeclado.nextInt();
        if (num<0){
            System.out.println("Negativo");
        } else if (a<10) {
            System.out.println("1 digito");
        } else if (a<100) {
            System.out.println("2 digitos");
        } else if (a<1000) {
            System.out.println("3 digitos");
        }
    }
}
