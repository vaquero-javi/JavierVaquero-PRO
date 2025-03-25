import model.*;

import java.util.ArrayList;

public class Entrada {
    ArrayList<Vehiculo> vehiculos;
    Coche coche = new Coche();
    Moto moto = new Moto();
    Patinete patinete =new Patinete();
    Bicicleta bicicleta = new Bicicleta();

    public Entrada (){
        vehiculos = new ArrayList<>();
    }
}
