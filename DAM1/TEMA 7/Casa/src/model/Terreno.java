package model;

import util.ExcepcionConstruccion;
import util.Orientacion;

public class Terreno {
    private Casa casa;
    private int metros;
    private Orientacion orientacion;
    private double valoracion;

    public Terreno(int metros, Orientacion orientacion, double valoracion) {
        this.metros = metros;
        this.orientacion = orientacion;
        this.valoracion = valoracion;
        this.casa = null;
    }

    public void construirCasa(int metrosCasa) throws ExcepcionConstruccion {
        if (this.casa != null) {
            throw new ExcepcionConstruccion("Ya hay una casa construida en el terreno.");
        }
        if (metrosCasa > this.metros) {
            throw new ExcepcionConstruccion("No hay suficiente espacio en el terreno para construir la casa.");
        }
        this.casa = new Casa(metrosCasa);
        this.metros -= metrosCasa;
    }

    //Esto no tenia ni idea y lo busque en chtgpt
    public void revalorizarCasa() {
        if (casa == null) return;
        double incremento = 1.25;
        if (casa.getMetros() > 100) incremento = 1.30;
        if (casa.tienePiscina()) incremento = 1.50;
        if (orientacion == Orientacion.NORTE || orientacion == Orientacion.SUR) incremento += 0.10;
        if (orientacion == Orientacion.ESTE || orientacion == Orientacion.OESTE) incremento += 0.05;
        this.valoracion *= incremento;
    }

    public Casa getCasa() {
        return casa;
    }

    public int getMetros() {
        return metros;
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    public double getValoracion() {
        return valoracion;
    }
}

