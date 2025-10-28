package controller;

import model.Armas;
import model.Superheroe;

import java.util.ArrayList;
import java.util.Comparator;

public class ControllerSuperheroes {

    ArrayList<Superheroe> listaSuperheroes = new ArrayList<>();
    ArrayList<Armas> listaArmas = new ArrayList<>();

    public void aniadirSuperheroes(Superheroe superheroe){
        listaSuperheroes.add(superheroe);
    }
    public void aniadirArma(Armas armas){
        listaArmas.add(armas);
    }

    public void   combateSuperHeroes(int id){
        if (estaSuperheroe(id) == null){
            System.out.println("No puedo eliminar a un superheroe que no existe");
        }else {
             estaSuperheroe(id);
             if (estaArmas(id) == null){
                 System.out.println("No hay armas ");
             }else {
                 estaArmas(id).setIdArmas(id);
             }

        }
    }
    public void  combateArmas(int idArmas){
        if (estaSuperheroe(idArmas) == null){
            System.out.println("No puedo eliminar a un superheroe que no existe");
        }else {
            listaArmas.remove(estaArmas(idArmas));
        }
    }

    public Superheroe estaSuperheroe(int id){
        for (Superheroe item : listaSuperheroes){
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }
    public Armas estaArmas(int id){
        for (Armas item : listaArmas){
            if (item.getIdArmas() == id){
                return item;
            }
        }
        return null;
    }

    public void mostrarInformacionSuperheroes(){
        for (Superheroe item : listaSuperheroes){
            System.out.println(item);
        }
    }
    public void mostrarInformacionArmas(){
        for (Armas item : listaArmas){
            System.out.println(item);
        }
    }

    public void enfrentarSuperheroes(){

        listaSuperheroes.sort(new Comparator<Superheroe>() {
            @Override
            public int compare(Superheroe o1, Superheroe o2) {
                int combate1 = o1.getNivelSuperheroe() + (o1.getArmas().getNivelPotencia() * o1.getArmas().getNivelDaño());
                int combate2 = o2.getNivelSuperheroe() + (o2.getArmas().getNivelPotencia() * o2.getArmas().getNivelDaño());
                if (combate1 > combate2){
                    return -1;
                } else if (combate1 < combate2) {
                    return 1;
                }else {
                    return 0;
                }
            }
        });
    }


}
