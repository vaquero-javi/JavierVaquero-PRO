package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hotel {
    private ArrayList<Object[]> listaHotel;

    public Hotel(){
        listaHotel=new ArrayList<>();
    }

    public boolean registrarReserva (int numHabitacion,  String nombreHuesped, int telefono, String dni, int numPersonas){
        Object[] reserva = new Object[]{numHabitacion, nombreHuesped, telefono,dni,numPersonas};

        if (!estaHabitacion(numHabitacion)) {
            listaHotel.add(reserva);
            return true;
        }
        return false;

        if (!estaPersona(dni)) {
            listaHotel.add(reserva);
            return true;
        }
        return false;
    }

    private Object[] estaHabitacion(int numHabitacion) {
        for (Object[] reserva : listaHotel) {
            if (reserva[0].equals(numHabitacion)) {
                //esta en la lista
                return reserva;
            }

        }
        //no esta en la lista
        return null;
    }
    private Object[] estaPersona(String dni) {
        for (Object[] reserva : listaHotel) {
            if (String.valueOf(reserva[3]).equalsIgnoreCase(dni)) {
                //esta en la lista
                return reserva;
            }
        }
        //no esta en la lista
        return null;

    }
    public void cancelarReserva(String dni) {
        boolean encontrado = false;
        for (Object[] reserva : listaHotel) {
            if (reserva.get().equals(dni)) {
                listaHotel.remove(reserva);
                System.out.println("Reserva cancelada para el huésped con DNI " + dni);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Error: No se encontró una reserva con el DNI " + dni);
        }
    }
    public void mostrarReservas() {
        if (listaHotel.isEmpty()) {
            System.out.println("No hay reservas actuales.");
        } else {
            for (Object[] reserva : listaHotel) {
                System.out.println("Nombre: "+reserva[1]+" Dni: "+reserva[3]+"Número de habitación: "+reserva[0]);
            }
        }
    }
    public void mostrarReservasOrdenadas(){
        Collections.sort(listaHotel, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] objects, Object[] t1) {
                if (Double.parseDouble(objects.toString()) > Double.parseDouble(t1.toString())){
                    return 1;

                }else if (Double.parseDouble(objects.toString()) < Double.parseDouble(t1.toString())){
                    return -1;

                }else{
                    return 0;
                }
            }
        });
    }
}

