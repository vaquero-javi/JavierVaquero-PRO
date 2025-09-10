package controller;

import model.Cliente;
import model.Consumiciones;

import java.util.ArrayList;

public class Restaurante {
    private ArrayList<Cliente>listaClientes;
    private double caja;

    public Restaurante() {
    }

    public Restaurante(ArrayList<Cliente> listaClientes, double caja) {
        this.listaClientes = listaClientes;
        this.caja = caja;
    }

    private  Cliente buscarCliente (String dni){
        for (Cliente cliente : listaClientes){
            if (cliente.getDni().equalsIgnoreCase(dni)){
                return cliente;
            }
        }
        return null;
    }

    public void agregarCliente (Cliente cliente){
        if (buscarCliente(cliente.getDni())==null){
            listaClientes.add(cliente);
        }else {
            System.out.println("Error, no se ha podido agregar el cliente");
        }
    }

    public void agregarConsumicion (Cliente cliente, Consumiciones consumiciones){
        if (buscarCliente(cliente.getDni())!=null){
            cliente.getListaConsumiciones().add(consumiciones);
        }else {
            System.out.println("Error, no puede pedir consumición");
        }
    }

    public void mostrarInfo (String dni){
        if (buscarCliente(dni) != null){
            buscarCliente(dni).mostrarDatosCliente();
        }else {
            System.out.println("Error, no se han podido mostrar los datos");
        }
    }

    public void totalPagar(String dni){
    }

    public void cajaTotal(){
        System.out.println("caja = " + caja);
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public double getCaja() {
        return caja;
    }

    public void setCaja(double caja) {
        this.caja = caja;
    }
}
