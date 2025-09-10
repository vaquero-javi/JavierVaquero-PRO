import model.Coche;

public class Entrada {
    public static void main(String[] args) {
        Coche coche1 = new Coche();
        Coche coche2 = new Coche("Ford","Focus","Gris");
        Coche coche3 = new Coche("Opel","Corsa",150);
        Coche coche4 = new Coche("BMW","Serie 1", "Rojo","1233421ASD","1234ABC",200, 25000);

        System.out.println("Los datos del coche uno son:");
        coche1.setMarca("Seat");
        coche1.mostrarDatos();

        System.out.println("Los datos del coche dos son:");
        coche2.mostrarDatos();

        System.out.println("Los datos del coche tres son:");
        coche3.mostrarDatos();

        System.out.println("Los datos del coche cuatro son:");
        coche4.mostrarDatos();

        //solo quiero sacar la marca del coche 3
        System.out.println("La marca del coche 3 es: "+coche3.getMarca());

    }
}
