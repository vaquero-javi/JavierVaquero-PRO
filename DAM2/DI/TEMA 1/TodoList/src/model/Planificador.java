package model;

import java.util.ArrayList;

public class Planificador {

    private ArrayList<Tarea> listaTareas;

    public Planificador() {
        listaTareas = new ArrayList<>();
    }

    private Tarea buscarTarea(int id) {
        for (Tarea tarea : listaTareas) {
            // Vamos a usar el hashCode de la tarea como id temporal
            if (tarea.hashCode() == id) return tarea;
        }
        return null;
    }

    public void agregarTarea(Tarea tarea) {
        listaTareas.add(tarea);
        System.out.println("Tarea agregada correctamente. ID: " + tarea.hashCode());
    }

    public void listarTareas() {
        if (listaTareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
        } else {
            for (Tarea tarea : listaTareas) {
                System.out.println("ID: " + tarea.hashCode() + " -> " + tarea);
            }
        }
    }

    public void listarCompletas() {
        for (Tarea tarea : listaTareas) {
            if (tarea.isCompletada()) {
                System.out.println("ID: " + tarea.hashCode() + " -> " + tarea);
            }
        }
    }

    public void listarIncompletas() {
        for (Tarea tarea : listaTareas) {
            if (!tarea.isCompletada()) {
                System.out.println("ID: " + tarea.hashCode() + " -> " + tarea);
            }
        }
    }

    public void completarTarea(int id) {
        Tarea tarea = buscarTarea(id);
        if (tarea == null) {
            System.out.println("No se encontró la tarea con ID: " + id);
            return;
        }

        boolean tieneSubtareasPendientes = false;
        for (Encargo e : tarea.getListaTareas()) {
            if (!e.isCompletada()) {
                tieneSubtareasPendientes = true;
                break;
            }
        }

        if (tieneSubtareasPendientes) {
            System.out.println("No se puede completar la tarea porque tiene encargos pendientes.");
        } else {
            tarea.setCompletada(true);
            System.out.println("Tarea completada correctamente.");
        }
    }

    public void modificarTarea(int id, String nuevoTitulo, String nuevaDescripcion, Boolean prioridad) {
        Tarea tarea = buscarTarea(id);
        if (tarea == null) {
            System.out.println("No se encontró la tarea con ID: " + id);
            return;
        }
        if (nuevoTitulo != null){
            tarea.setTitulo(nuevoTitulo);
        }
        if (nuevaDescripcion != null){
            tarea.setDescripcion(nuevaDescripcion);
        }
        if (prioridad != null){
            tarea.setPrioritario(prioridad);
        }

        System.out.println("Tarea modificada correctamente.");
    }

    public void agregarResponsable(int id, Persona p) {
        Tarea tarea = buscarTarea(id);
        if (tarea == null) {
            System.out.println("No se encontró la tarea con ID: " + id);
            return;
        }
        tarea.asignarResponsable(p);
    }

    public void agregarEncargo(int id, Encargo e) {
        Tarea tarea = buscarTarea(id);
        if (tarea == null) {
            System.out.println("No se encontró la tarea con ID: " + id);
            return;
        }
        tarea.agregarEncargo(e);
    }

}
