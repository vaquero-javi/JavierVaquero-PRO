import controller.Plataforma;
import model.Videojuego;
import model.VideojuegoAccion;

public class Main {
    public static void main(String[] args) {
        Videojuego videojuego1 = new VideojuegoAccion(1,"Fifa","EA","Diez",2020,120.2, 1.1, 2, true);
        Videojuego videojuego2 = new VideojuegoAccion(2,"GTA","EA","Doce",2015,100.2, 3.4, 5, true);
        Plataforma plataforma = new Plataforma();

        plataforma.aniadirJuegos(videojuego1);
        plataforma.aniadirJuegos(videojuego2);

        plataforma.ordenarXPrecio();

        plataforma.ordenarXEdad("Nueve");

        plataforma.precioTotal();

        //plataforma.eliminarJuegos(1);
    }
}