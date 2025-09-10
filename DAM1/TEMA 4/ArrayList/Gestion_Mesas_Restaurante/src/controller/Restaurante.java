package controller;

import java.util.ArrayList;

public class Restaurante {
    private ArrayList<Object[]> listaRestaurante = new ArrayList<>();

    double bocadillo=5.5;
    double taco=6.5;
    double hamburguesa=7.5;

    public void asignarMesa(String nombre, int numMesa, String consumiciones){
        Object[] mesa = new Object[]{nombre, numMesa, consumiciones};

        if (listaRestaurante.size() < 10) {
            if (!estaMesa(nombre) == null) {
            listaRestaurante.add(mesa);
                System.out.println("Confirmación");
            }else {
                System.out.println("Error");
            }
        }else{
            System.out.println("Error, el restaurante está lleno");
        }
    }

    private boolean estaMesa(String nombre) {

        for (Object[] mesa : listaRestaurante) {
            if (mesa[0].equals(nombre)) {
                return true;
            }
        }

        return false;
    }

    public boolean liberarMesas(int numMesa){
        for (Object[] mesa: listaRestaurante){
            if (mesa[1].equals(numMesa)){
                listaRestaurante.remove(mesa);
                System.out.println("Confirmación, mesa liberada");
                return true;
            }
        }
        System.out.println("Error, mesa no encontrada");
        return false;
    }

    public void realizarPedido(String consumiciones){
        listaRestaurante.add(consumiciones);
    }

    public void mostrarMesasOcupadas(){
        if (listaRestaurante.isEmpty()) {
            System.out.println("Error, no hay mesas asignadas");
        }else {
            for (Object[] mesa: listaRestaurante){
                System.out.println(mesa[1]+"-"+mesa[0]+"-"+mesa[2]);
            }
        }
    }

}




