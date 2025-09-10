package Controller;

import Dto.CocheDto;
import Model.Coche;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CentroController {
    private CocheDto cocheDto;
    private ArrayList<Coche> listacoches;

    public CentroController (){
        cocheDto = new CocheDto();
        listacoches = new ArrayList<>();
    }

    public void insertarCoche(Coche coche){
        if (coche == null){
            System.out.println("Error! El coche ya estaba añadido");
        }else {
            cocheDto.insertarCoche(coche);
            listacoches.add(coche);
            System.out.println("Enhorabuena! Tu coche se ha añadido");
        }

    }

    public void obtenerCoche(Coche coche){
        if (coche == null){
            System.out.println("No se ha podido obtener los coches");
        }else{
            cocheDto.getCoche(coche);
        }
    }

    public void obtenerCocheByID(int id){
        if (id == -1){
            System.out.println("Error, no has podido obtener el coche mediante el id");
        }else {
            cocheDto.getCocheById(id);
        }

    }

    public void borrarCocheByID (int id){
        if (id == -1){
            System.out.println("Error, no has podido borrar el coche mediante el id");
        }else {
            cocheDto.deleteCocheByID(id);
            listacoches.remove(id);
        }

    }

    public void exportarACSV() {
        String nombreArchivo = "coches.csv";

        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write("Matrícula;Marca;Modelo\n");
            for (Coche coche : listacoches) {
                writer.write(
                        String.format("%s;%s;%s\n", coche.getMatricula(), coche.getMarca(), coche.getModelo())
                );
            }
            System.out.println("Datos exportados correctamente a " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("Error al exportar a CSV: " + e.getMessage());
        }
    }

}
