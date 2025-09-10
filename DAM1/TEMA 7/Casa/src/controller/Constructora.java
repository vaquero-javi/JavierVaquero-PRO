package controller;

import model.Terreno;
import model.Casa;
import util.Orientacion;
import util.ExcepcionConstruccion;

public class Constructora {
    public static Terreno crearTerreno(int metros, Orientacion orientacion, double valoracion) {
        return new Terreno(metros, orientacion, valoracion);
    }

    public static void construirCasa(Terreno terreno, int metrosCasa) throws ExcepcionConstruccion {
        terreno.construirCasa(metrosCasa);
    }
}
