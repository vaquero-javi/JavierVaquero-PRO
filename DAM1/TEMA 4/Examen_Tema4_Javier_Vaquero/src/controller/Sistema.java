package controller;

import java.util.ArrayList;
import java.util.Scanner;

Scanner scanner = new Scanner(Sysyem.in);
public class Sistema {

    private ArrayList<Object[]> listaUsuarios = new ArrayList<>();

    public void agregarUsuario(String nombre, String apellido, int telefono, String dni){
        Object[] usuarios= new Object[];

        System.out.println("Introduce tu nombre");
        nombre=scanner.nextLine();
        System.out.println("Introduce tu apellido");
        apellido=scanner.nextLine();
        System.out.println("Introduce tu telefono");
        telefono=scanner.nextInt();
        System.out.println("Introduce tu dni");
        dni=scanner.next();

        listaUsuarios.add(usuarios);


    }

    public boolean borrarUsuario(String dni){
        Object[] usuarios= new Object[];

        System.out.println("Introduce tu dni");
        dni=scanner.nextLine();
        listaUsuarios.clear(usuarios);
    }





}
