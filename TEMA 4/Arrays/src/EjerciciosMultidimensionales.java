import java.util.Scanner;

public class EjerciciosMultidimensionales {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        //definir array con filas 5 y columnas aleatorias entre 2-6
        //rellenar el array (entero) con aleatorios

        int[][]numero=new int[5][(int) ((Math.random()*5)+2)];
        for (int i = 0; i < numero.length; i++) {
            for (int j = 0; j < numero[i].length; j++) {
                numero[i][j]= (int) (Math.random()*21);
            }
        }
        System.out.println("Array original");
        imprimirArray(numero);


        //al array hay que quitarle uno a cada posicion y volver a imprimir
        for (int i = 0; i < numero.length; i++) {
            for (int j = 0; j < numero[i].length; j++) {
                numero[i][j]-=1;
            }
        }
        System.out.println("Array modificado");
        imprimirArray(numero);


        //el usuario 8 veces diga de modificar el array en X veces
        for (int i = 0; i < 9; i++) {
            System.out.println("En cuanto quieres modificar el valor");
            int modificar= scanner.nextInt();
            for (int j = 0; j < numero.length; j++) {
                for (int k = 0; k < numero[i].length; k++) {
                    numero[i][j]-=modificar;
                }
            }
        }

    }


    public static void imprimirArray(int[][] array){
        for (int[] item : array) {
            for (int element : item) {
                System.out.print(element+ "\t");
            }
            System.out.println();
        }
    }

}
