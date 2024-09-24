public class Prueba1 {
//haz variables donde se vean los numeros max y min de cada metodo
    public static void main (String[] args){
        System.out.println("Estos son los valores minimos de las siguientes variables:");
        valoresMin();
        System.out.println("Ahora vamos a mostraros los valores maximos de las siguientes variables:");
        valoresMax();
    }

    public static void valoresMin(){
        System.out.printf("El valor minimo de un entero es %d\n", Integer.MIN_VALUE);
        System.out.printf("El valor minimo de un double es %.2f\n", Double.MIN_VALUE);
        System.out.printf("El valor minimo de un float es %.2f\n", Float.MIN_VALUE);
        System.out.printf("El valor minimo de un byte es %d\n", Byte.MIN_VALUE);
    }

    public static void valoresMax(){
        System.out.printf("El valor maximo de un entero es %d\n", Integer.MAX_VALUE);
        System.out.printf("El valor maximo de un double es %.2f\n", Double.MAX_VALUE);
        System.out.printf("El valor maximo de un float es %.2f\n", Float.MAX_VALUE);
        System.out.printf("El valor maximo de un byte es %d\n", Byte.MAX_VALUE);
    }


}
