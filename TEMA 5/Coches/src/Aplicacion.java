import model.Coche;
import model.Garaje;
import model.Motor;

import java.util.Scanner;

public class Aplicacion {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Garaje garaje = new Garaje();

        System.out.println("Introduce la marca de tu coche1");
        String marca = scanner.next();
        System.out.println("Introduce el modelo de tu coche1");
        String modelo = scanner.next();
        System.out.println("Introduce la matricula de tu coche1");
        String matricula = scanner.next();
        System.out.println("Introduce los cv de tu coche1");
        int cv = scanner.nextInt();
        Coche coche1 = new Coche(marca, modelo, matricula);
        coche1.setMotor(new Motor(cv));

        System.out.println("Introduce la marca de tu coche2");
        marca = scanner.next();
        System.out.println("Introduce el modelo de tu coche2");
        modelo = scanner.next();
        System.out.println("Introduce la matricula de tu coche2");
        matricula = scanner.next();
        System.out.println("Introduce los cv de tu coche2");
        cv = scanner.nextInt();
        Coche coche2 = new Coche(marca, modelo, matricula);
        coche2.setMotor(new Motor(cv));

        for (int i = 0; i < 2; i++) { // Cada coche entra al menos 2 veces
            // Coche 1
            if (garaje.aceptarCoche(coche1, i == 0 ? "aceite" : "frenos")) {
                coche1.acumularAverias(coche1.getPrecioAverias());
                if (garaje.getAveria().equals("aceite")) {
                    coche1.getMotor().setLitrosAceite(coche1.getMotor().getLitrosAceite() + 10); // Incrementar aceite
                } else {
                    coche1.getMotor().setLitrosAceite(coche1.getMotor().getLitrosAceite() + (int) (Math.random() * 101)); // Aleatorio entre 0 y 100
                }
                garaje.devolverCoche(coche1, 1);
            }


        }
    }
