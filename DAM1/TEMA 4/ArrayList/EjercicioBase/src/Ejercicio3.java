import java.util.ArrayList;

public class Ejercicio3 {
    /*
    Crea dos ArrayList de números y guarda de forma aleatorio 20 números sin decimales en cada uno de ellos.
    Una vez hecho esto comprueba cuantos números de los dos arraylist son iguales (mismo número en la misma posición).
    Tras hacer la comprobación indica cuantos números han sido iguales
     */

    private static ArrayList<Integer> numeros1 = new ArrayList<>();
    private static ArrayList<Integer> numeros2 = new ArrayList<>();


    public static void main(String[] args) {
        anadirnumeros(numeros1);
        anadirnumeros(numeros2);
        System.out.println("El numero de repetidos es "+cuantosRepetidos());
    }

    public static void anadirnumeros(ArrayList<Integer>lista) {
        for (int i = 0; i < 20; i++) {
            lista.add((int) (Math.random()*21));
        }

    }
    public static int cuantosRepetidos (){
        int repetidos = 0;
        for (int i = 0; i < numeros1.size(); i++) {
            if (numeros1.get(i) == numeros2.get(i)) {
                repetidos++;
            }
        }
        return repetidos;
    }

}
