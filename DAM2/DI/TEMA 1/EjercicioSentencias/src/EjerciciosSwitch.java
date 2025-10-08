import java.util.Scanner;

public class EjerciciosSwitch {
    Scanner scanner = new Scanner(System.in);

    //Ejercicio 1
    //Ingresa un carácter y determina si es vocal o consonante usando switch.
    public void vocalOconsonante(){
        System.out.println("1.Ingresa un carácter y determina si es vocal o consonante usando switch.");
        System.out.println("Introduce un caracter");
        char letra = scanner.next().toLowerCase().charAt(0);

        switch (letra){
            case 'a': case 'e': case 'i':  case 'o': case 'u':
                System.out.println("Es vocal");
                break;
            default:
                System.out.println("Es consonante");
                break;
        }
    }

    //Ejercicio 2
    //Recibe un entero y determina si es par o impar usando switch.
    public void parOimpar(){
        System.out.println("2.Recibe un entero y determina si es par o impar usando switch.");
        System.out.println("Introduce un número entero");
        int a = scanner.nextInt();

        switch (Math.abs(a)%2){
            case 0:
                System.out.println("Es par");
                break;
            default:
                System.out.println("Es impar");
                break;
        }
    }

    //Ejercicio 3
    //Pide un operador (+, -, *, /) y dos números; realiza la operación con switch.
    public void calculadora(){
        System.out.println("3.Pide un operador (+, -, *, /) y dos números; realiza la operación con switch.");
        System.out.println("Introduce un numero");
        int num1 = scanner.nextInt();
        System.out.println("Introduce un numero");
        int num2 = scanner.nextInt();
        System.out.println("Introduce + , - , * , / ");
        char simbolo = scanner.next().charAt(0);

        switch (simbolo){
            case '+':
                System.out.println(num1 + num2);
                break;
            case '-':
                System.out.println(num1 - num2);
                break;
            case '*':
                System.out.println(num1 * num2);
                break;
            case '/':
                System.out.println(num1 / num2);
                break;
        }
    }

    //Ejercicio 4
    //Pide un número 1-12 y muestra la estación correspondiente con switch.
    public void mesAanio(){
        System.out.println("4.Pide un número 1-12 y muestra la estación correspondiente con switch.");
        System.out.println("Introduce un numero del 1-12");
        int num = scanner.nextInt();

        switch (num){
            case 12: case 1: case 2:
                System.out.println("Invierno");
                break;
            case 3: case 4: case 5:
                System.out.println("Primavera");
                break;
            case 6: case 7: case 8:
                System.out.println("Verano");
                break;
            case 9: case 10: case 11:
                System.out.println("Otoño");
                break;
            default:
                System.out.println("No has puesto un numero del 1-12");
                break;
        }
    }

    //Ejercicio 5
    //Lee un código de producto y muestra nombre y precio con switch.
    public void codigoProducto(){
        System.out.println("5.Lee un código de producto y muestra nombre y precio con switch.");
        System.out.println("CODIGOS PRODUCTOS:");
        System.out.println("1234A");
        System.out.println("1234B");
        System.out.println("1234C");
        System.out.println("Introduce un codigo de producto");
        String codigo = scanner.next();
        switch (codigo){
            case "1234A":
                System.out.println("Producto: lápiz, Precio: 1$");
                break;
            case "1234B":
                System.out.println("Producto: borrados, Precio: 2$");
                break;
            case "1234C":
                System.out.println("Producto: boli, Precio: 3$");
                break;
            default:
                System.out.println("No pusiste el codigo de producto bien");
                break;
        }

    }
}
