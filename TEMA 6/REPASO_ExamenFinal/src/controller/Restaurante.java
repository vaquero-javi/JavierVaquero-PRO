package controller;

import model.Cliente;
import model.Consumicion;
import util.DatosFiscales;
import util.Proveedor;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {

    private ArrayList<Cliente> listaClientes;
    private double caja;
    private Proveedor proveedor;

    public Restaurante(Proveedor proveedor) {
        listaClientes = new ArrayList<>();
        this.proveedor = proveedor;
    }

    public Restaurante(){
        listaClientes = new ArrayList<>();
        //proveedor = null
    }

    public void mostrarDatosFiscales(){
        System.out.println("El NIF es "+ DatosFiscales.NIF);
        System.out.println("La direccion es "+ DatosFiscales.DIR_FISCAL);
        System.out.println("El IVA es "+ DatosFiscales.IVA);
    }

    public void informacionProveedor(){
        if(proveedor == null){
            System.out.println("El restaurante no tiene proveedor");
        }else {
            System.out.println("La informacion del proveedor es: " );
            //nombre del Enum
            System.out.println("El nombre del Enum es: "+proveedor.name());
            //nombre
            System.out.println(proveedor.getNombre());
            System.out.println(proveedor.getContacto());
            System.out.println(proveedor.getDescuento());
        }
    }

    // admitir clientes. Tan solo se podrá admitir un cliente
    // si no existe uno con ese nombre
    public void agregarCliente(Cliente cliente){
        // no pido los datos aqui!!!, esto lo hace la ENTRADA - UI->l controlador es la LOGICA
        // metera al cliente dentro de la lista
        if (estaCliente(cliente.getNombre())!=null){
            System.out.println("Ya esta en el resutaurante");
        } else {
            listaClientes.add(cliente);
            System.out.println("Bienvenido al resultaurante");
        }
    }

    // obtener informacion de todos los clientes que estan en el resustaurante
    // en el caso de tener un cliente sin consumiciones, deberá aparecer el mensaje
    // aun no ha pedido
    public void mostrarClientes(){
        for (Cliente cliente: listaClientes) {
            cliente.mostrarDatos();
        }
    }

    private Cliente estaCliente(String nombre){
        for ( Cliente cliente : listaClientes ) {
            if (cliente.getNombre().equalsIgnoreCase(nombre)){
                return cliente;
            }
        }
        return null;
    }

    // un cliente puede pedir una una consumicion
    // si en la lista de consumiciones del cliente, ya existe ese producto
    // preguntar si realmente quiere pedirlo. En el caso de decir que si
    // preguntar si quiere agregar mas de uno, e indicar el numero concreto
    public void agregarPedido(Consumicion consumicion, String nombre){
        Cliente cliente = estaCliente(nombre);
        // if cliente !=null
        if (!estaConsumicion(consumicion.getNombre(),cliente)){
            // false, por lo tanto no está, por lo tanto, la agrego
            agregarConsumicion(cliente,consumicion);
        } else {
            // true, por lo tanto la consumicion esta en la lista, por lo tanto pregunto si quiere repetirla
            Scanner scanner = new Scanner(System.in);
            System.out.println("Veo que ya tienes una consumicion de este tipo, quieres repetirma");
            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("s")){
                // si quiere repetir, pregunto cuantas quiere
                System.out.println("Cuantas quieres de mas");
                int numero = scanner.nextInt();
                // if (numero<0) -> while
                for (int i = 0; i < numero; i++) {
                    agregarConsumicion(cliente,consumicion);
                }

            } else {
                // no quiere repetir, por lo tanto agrega solo 1
                agregarConsumicion(cliente,consumicion);
            }
        }

    }

    private void agregarConsumicion(Cliente cliente, Consumicion consumicion){
        cliente.getConsumiciones().add(consumicion);
        cliente.incrementarFactura(consumicion.getPrecio());
    }
    private boolean estaConsumicion(String nombreConsumicion,
                                    Cliente cliente){

        for (Consumicion consumicion : cliente.getConsumiciones()) {
            if (consumicion.getNombre().equalsIgnoreCase(nombreConsumicion)){
                return true;
            }
        }
        return false;
    }

    public void pedirCuenta(String nombre){
        Cliente cliente = estaCliente(nombre);
        if (cliente==null){
            System.out.println("No se encuentra este cliente en la lista");
        } else {
            caja += cliente.getTotalFactura();
        }
    }

    public void mostrarDatosCliente(String nombre){
        Cliente cliente = estaCliente(nombre);
        if (cliente==null){
            System.out.println("No se encuentra este cliente en la lista");
        } else {
            System.out.println("Sus consumiciones son");
            for (Consumicion consumicion: cliente.getConsumiciones()) {
                consumicion.mostrarDatos();
            }
        }
    }
    public void mostrarCajaRestaurante(){
        System.out.println(caja);
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

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
