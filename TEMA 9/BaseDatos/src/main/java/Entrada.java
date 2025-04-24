import database.DBConnector;
import dto.UsuarioDTO;
import model.Usuario;

import java.sql.Connection;

public class Entrada {
    public static void main(String[] args) {
        //Connection connection = DBConnector.getConnection();

        Usuario usuario = new Usuario("Juan","juan@gmail.com","1234",0,0,0);
        System.out.println(usuario.getNombre());
        UsuarioDTO usuarioDTO =
    }
}
