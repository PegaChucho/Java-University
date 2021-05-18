package data;

import domain.Usuario;
import java.sql.*;
import java.util.*;

public interface IUsuarioDAO {

    String SQL_SELECT = "SELECT id_usuario, usuario, password FROM usuario";
    String SQL_INSERT = "INSERT INTO usuario(usuario, password) VALUES(?,?)";
    String SQL_UPDATE = "UPDATE usuario SET usuario=?, password=? WHERE (id_usuario = ?)";
    String SQL_DELETE = "DELETE FROM usuario where id_usuario = ?";

    public List<Usuario> seleccionar() throws SQLException;

    public int insertar(Usuario usuario) throws SQLException;

    public int actualizar(Usuario usuario) throws SQLException;

    public int borrar(Usuario usuario) throws SQLException;

}
