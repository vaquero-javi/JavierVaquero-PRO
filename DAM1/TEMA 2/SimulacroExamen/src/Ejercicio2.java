import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner escribirTeclado = new Scanner(System.in);

        System.out.println("Introduce el nombre del participante");
        String nombreParticipante1 = escribirTeclado.nextLine();

        System.out.println("Introduce el numero de jugadores del participante");
        int numJugadores1 = escribirTeclado.nextInt();

        System.out.println("Presupuesto del participante");
        int presupuestoParticipante1 = escribirTeclado.nextInt();


        System.out.println("Introduce el nombre del siguiente participante");
        String nombreParicipante2 = escribirTeclado.next();     //con nextLine no me iba

        System.out.println("Introduce el numero de jugadores del participante");
        int numJugadores2 = escribirTeclado.nextInt();

        System.out.println("Presupuesto del participante");
        int presupuestoParticipante2 = escribirTeclado.nextInt();


        System.out.println("Introduce el nombre del siguiente participante");
        String nombreParticipante3 = escribirTeclado.next();

        System.out.println("Introduce el numero de jugadores del participante");
        int numJugadores3 = escribirTeclado.nextInt();

        System.out.println("Presupuesto del participante");
        int presupuestoParticipante3 = escribirTeclado.nextInt();

        System.out.println("¿El primer participante tiene 11 jugadores?");
        boolean comparar = numJugadores1 == 11;
        System.out.println(comparar);

        System.out.println("¿Elsegundo participante tiene jugadores pares?");
        boolean pares = numJugadores2 % 2 == 0;
        System.out.println(pares);

        System.out.println("¿El tercer participante tiene presupuesto positivo:?");
        boolean positivo = presupuestoParticipante3 > 0;
        System.out.println(positivo);

        System.out.println("¿La liga está preparada para empezar?");
        boolean liga = numJugadores1 == 11 && numJugadores2 == 11 && numJugadores3 == 11
                && presupuestoParticipante1 > 0 && presupuestoParticipante2 > 0 && presupuestoParticipante3 > 0;
        System.out.println(liga);
    }
}
