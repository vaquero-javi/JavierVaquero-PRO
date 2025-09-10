import model.Coche;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Carrera {
static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*
        listacoches.add(new Coche("Ford", "Focus", "Plata"));
        listacoches.add(new Coche("Seat", "Ibiza", "Negro"));
        listacoches.add(new Coche("Mercedes", "C300",400));

        for (Coche coche: listacoches){
            coche.mostrarDatos();
        }

         */
        ArrayList<Coche> participantes = new ArrayList<>();

        int km;
        int vueltas;

        System.out.println("Antes de comenzar la carrera...");
        for (int i = 0; i < 6; i++) {
            System.out.println("Introduce la marca del participante "+(i+1));
            String marca= scanner.nextLine();
            System.out.println("Introduce el modelo del participante "+(i+1));
            String modelo=scanner.nextLine();
            System.out.println("Introduce la matricula del participante "+(i+1));
            String matricula=scanner.nextLine();
            System.out.println("Introduce los cv del participante "+(i+1));
            int cv = scanner.nextInt();

            Coche coche = new Coche(marca,modelo,matricula, cv);
            participantes.add(coche);

        }

        System.out.println("¿Cuantas vueltas tiene la carrera?");
        vueltas=scanner.nextInt();

        System.out.println("Va a comenzar la carrera...");
        for (int i = 0; i < vueltas; i++) {
            for(Coche coche : participantes){
            int kmAleatorio= (int) (Math.random()*26)+50;
            coche.setKm(kmAleatorio);
            }
        }

        System.out.println("El coche ganador es...");
        participantes.sort(new Comparator<Coche>() {
            @Override
            public int compare(Coche coche, Coche t1) {
                if (coche.getKm() > t1.getKm()){
                    return -1;
                } else if (coche.getKm()<t1.getKm()) {
                    return 1;
                }
                return 0;
            }
        });
        System.out.println("El ganador de la carrera es "+ participantes.get(0).getKm());


        System.out.println("La clasificación es...");
        int posicion=1;
        for (Coche coche : participantes){
            System.out.println(posicion + "-"+ coche.getMarca()+ "-"+coche.getModelo()+"-"+ coche.getKm());
            posicion++;
        }

    }
}



/*
Un coche tiene un atributo KM,
los cuales pueden decir la distancia que ha recorrido un coche
Para poder hacer una carrera, es necesario que se pida por cocnsola
los datos de 6 participantes, donde se debe undicar la marca, modelo, matricula,cv .
Una vez indicados todos los participantes, es necesario indicar cuantas vueltas consta la carrera.
Una vez indicada el numero de vueltas la carrera comienza. Para ello en cada vuelta
cada coche recorre un numero de KM aleatorio entre 50-75.
Una vez que se terminan todas las vueltas el sistema mostrara:
    -El coche ganador es XXX XXX XXX
    -La clasificacion es XXX XXX XXX ordenado por KM recorridos
 */