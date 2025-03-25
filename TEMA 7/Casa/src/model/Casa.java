package model;

import util.ExcepcionConstruccion;

public class Casa {
    private int metros;
    private boolean piscina;
    private int habitaciones;

    public Casa() {
    }

    public Casa(int metros) {
        this.metros = metros;
        this.piscina = false;
        this.habitaciones = 0;
    }

    public void construirHabitacion(int metrosHabitacion) throws ExcepcionConstruccion {
        if (metrosHabitacion > this.metros) {
            throw new ExcepcionConstruccion("No hay suficientes metros disponibles en la casa.");
        }else {
            this.metros -= metrosHabitacion;
            this.habitaciones++;
        }

    }

    public void construirPiscina() throws ExcepcionConstruccion {
        if (this.piscina) {
            throw new ExcepcionConstruccion("Ya hay una piscina en la casa.");
        }
        this.piscina = true;
    }

    public int getMetros() {
        return metros;
    }

    public boolean tienePiscina() {
        return piscina;
    }

    public int getHabitaciones() {
        return habitaciones;
    }
}

