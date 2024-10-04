import java.util.Scanner;

public class Ejercicio5 {
    static Scanner escribirTeclado = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("VAMOS A CALCULAR EL AREA DEL TRIANGULO:");
        System.out.println("Introduce un valor para la base del triangulo");
        int base = escribirTeclado.nextInt();
        System.out.println("Introduce un valor para el lado 2 del triangulo");
        int lado2 = escribirTeclado.nextInt();
        System.out.println("Introduce un valor para la lado 3 del triangulo");
        int lado3 = escribirTeclado.nextInt();
        System.out.println("Introduce un valor para la altura del triangulo");
        int altura = escribirTeclado.nextInt();
        int triangulo = areaTriangulo(base, altura);
        System.out.printf("El área del triángulo con base %d y altura %d es %d\n",base,altura,triangulo);
        boolean isosceles = ((base==lado2)&&(lado2!=lado3)) || ((base != lado2)&&(lado2 ==lado3))
                ||((base != lado2 )&&(lado2 !=lado3))||((base != lado3)&&(lado3 ==lado2));
        System.out.println("El triangulo es isosceles: "+isosceles);
        boolean equilatero = ((base == lado2)&&(lado2 ==lado3));
        System.out.println("El triangulo es equilatero: "+equilatero);

        System.out.println("=======================================");
        System.out.println("VAMOS A CALCULAR EL AREA DEL CIRCULO:");
        System.out.println("Introduce un valor para el radio del circulo");
        int radio = escribirTeclado.nextInt();
        double circulo = areaCirculo(radio);
        System.out.printf("El area del circulo es %.2f\n",circulo);
    }
    public static int areaTriangulo (int base, int altura){
        return  base*altura/2;
    }
    public static double areaCirculo (int radio){
        return  Math.PI * Math.pow(radio,2);
    }
}
