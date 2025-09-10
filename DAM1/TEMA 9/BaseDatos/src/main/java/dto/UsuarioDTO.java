package dto;

import database.DBConnector;
import database.SchemaDB;
import model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDTO {

    //representa el servicio contra la base de datos

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public UsuarioDTO(){
        connection = DBConnector.getConnection();
    }

    //CRUD

    //comun: db_name, col_name

    //CREATE -> INSERT INTO usuarios (nombre,correo,pass,perfil) VALUES ('Javi','Martin','correo','pass',5
    public void insertaUsuarioz(Usuario usuario){
        try {
            statement = connection.createStatement();
            //String query = "INSERT INTO" + SchemaDB.DB_NAME + "(" +SchemaDB.COL_NAME+","+SchemaDB.+",pass,perfil) VALUES ('Javi','Martin','correo','pass',5"
            String query = "INSERT INTO %s (%s,%s,%s,%s) VALUES ('%s','%s','%s','%s',%d)";
            StringQueryFormateo = String.format(query,SchemaDB.TAB_USER,SchemaDB.COL_NAME,SchemaDB.COL_MAIL,
                    SchemaDB.COL_PASS,SchemaDB.COL_PROFILE,
                    usuario.getNombre(),usuario.getCorreo(),usuario.getCorreo(),usuario.getPass());
        } catch (SQLException e) {
            System.out.println("Error en la query");
        }
    }
}
