import java.util.Scanner;

public class Entrada {
    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        //ejercicio1();
        //ejercicio2();
        //ejercicio3();
        //ejercicio4();
    }

    public static void ejercicio1(){
        /*
        1. Realiza una aplicación que permita, mediante un menú iterativo realizar
            operaciones matemáticas. Para ello, el flujo del programa será el siguiente:
        a. Usuario podrá introducir por consola los dos operandos
        b. En el caso de que ambos números sean positivos, se mostrará un
            menú ofreciendo las opciones de suma, resta, multiplicación y división
        c. En el caso de que alguno de los números sea negativo, aparecerá un
            mensaje avisando de que no se pueden realizar operaciones sobre números negativos
         */
        int numero1=0;
        int numero2=0;
        int opcion=0;
        System.out.println("Introduce un numero");
        numero1= scanner.nextInt();
        System.out.println("Introduce otro numero");
        numero2=scanner.nextInt();
        int suma= numero1+numero2;
        int resta= numero1-numero2;
        int multiplicacion= numero1*numero2;
        double division= (double)numero1/numero2;
        if (numero1 > 0 && numero2 > 0) {
            System.out.println("1-Suma");
            System.out.println("2-Resta");
            System.out.println("3-Multiplicación");
            System.out.println("4-División");
            System.out.println("5-Salir");
            do {
            System.out.println("¿QUÉ QUIERES SABER?");
            opcion= scanner.nextInt();
                switch (opcion){
                    case 1:
                        System.out.println("La suma de los dos numeros introducidos es "+suma);
                        break;
                    case 2:
                        System.out.println("La resta de los dos numeros introducidos es "+resta);
                        break;
                    case 3:
                        System.out.println("La multiplicacion de los dos numeros introducidos es "+multiplicacion);
                        break;
                    case 4:
                        System.out.printf("La division de los dos numeros introducidos es %.2f\n",division);
                        break;
                    case 5:
                        System.out.println("Saliendo...");
                        break;
                }
            }while (opcion!=5);

        }else {
            System.out.println("No se pueden realizar operaciones sobre números negativos");
        }
    }

    public static void ejercicio2(){
        /*
            Crea una aplicación que pronostique los números de la bonoloto. Lo primero
            que pasará es que se le pide al usuario un número. A continuación, el
            sistema generará de forma automática 10 números entre 1 y 100. Una vez
            generados, se mostrará:
                a. El número más grande generado
                b. El número más pequeño generado
                c. El número medio generado
                d. La suma de todos los números
                e. Si el numero introducido por el usuario es alguno de los generados
         */
        int numero;
        int numeroAleatorio;
        int numeroMayor=0;
        int numeroMenor=100;
        int sumatorio=0;
        System.out.println("Introduce un numero del 1 al 100");
        numero=scanner.nextInt();

        for (int i = 0; i < 10; i++) {
            numeroAleatorio = (int) (Math.random() * 99)+1;
            if (numeroAleatorio > numeroMayor) {
                numeroMayor=numeroAleatorio;
            }else {
                numeroMenor=numeroAleatorio;
            }
            System.out.println("el numero más grande es "+numeroMayor);
            System.out.println("el numero más pequeño es "+numeroMenor);
            sumatorio+=numeroAleatorio;
            System.out.println("La media es "+sumatorio/10);
            if (numero==numeroAleatorio){
                System.out.println("El numero introducido coincide con alguno de los generados");
            }
        }

    }

    public static void ejercicio3(){
        /*
        Realiza un programa que permita abrir una caja fuerte. Para ello, crea una
        variable donde guardas la clave de apertura (número de 4 dígitos). A
        continuación, el sistema empieza a pedir números al usuario para que
        pueda abrir la caja. El usuario contará con 4 intentos. El programa podrá
        ejecutar los siguientes casos:
            a. Si el usuario falla en su intento y todavía no ha agotado intentos aparecerá el mensaje
            “Intento fallido, prueba de nuevo”
            b. Si el usuario falla en su intento apareceré le mensaje de “Lo siento, caja bloqueada”
            c. Si el usuario adivina la combinación en 4 intentos o menos aparecerá el mensaje
            “Perfecto, la caja ha sido abierta”
         */
        final int PIN=1111;
        int pinUs;
        for (int i = 0; i < 4; i++) {
            System.out.println("Introduce el PIN");
            pinUs=scanner.nextInt();
            if (pinUs != PIN) {
                System.out.println("Intento fallido");
            }else {
                System.out.println("Perfecto, la caja ha sido abierta");
                break;
            }
            if (pinUs !=PIN && i==3) {
                System.out.println("Caja bloqueada");
            }
        }

    }

    public static void ejercicio4(){
        /*
        Crea una aplicación que permita al usuario introducir un numero en base
        decimal. Una vez introducido, en el caso de que sea negativo, saltará un
        aviso de que no se puede hacer la operación. En el caso de que el número
        sea positivo, saltará un menú para poder elegir el tipo de cambio de base
            a. Base 2
            b. Base 8
            c. Base 16.
        Cuando el usuario selecciona la base, se mostrará el resultado y volverá a
        salir el menú
         */
        System.out.println("Introduce un numero");
        int numero= scanner.nextInt();
        int opcion=0;
        String binario;


        if (numero < 0) {
            System.out.println("No se puede hacer la operación");
        }else {
            do {
                System.out.println("1-Pasar a base 2");
                System.out.println("2-Pasar a base 8");
                System.out.println("3-Pasar a base 16");
                System.out.println("4-Salir");
                switch (opcion){
                    case 1:
                        do {
                            numero%=2;
                            numero/=2;

                        }while (numero<2);

                }
            }while (opcion!=4);

        }
    }
}
