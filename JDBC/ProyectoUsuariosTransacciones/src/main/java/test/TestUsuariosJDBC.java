package test;

import data.*;
import static data.Conexion.*;
import domain.Usuario;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestUsuariosJDBC {

    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        IUsuarioDAO usuarioTest = null;

        try {
            conn = getConnection();
            if (conn.getAutoCommit()) {
                conn.setAutoCommit(false);
            }

            usuarioTest = new UsuarioDAOImp(conn);

            var usuarioAct = new Usuario(1, "jperezgarcia", "Deloitte*");
            usuarioTest.actualizar(usuarioAct);

            var usuarioNew = new Usuario("Ronja", "Whiskas666");
            usuarioTest.insertar(usuarioNew);

            System.out.println("Exito en la operación, se ha actualizado la tabla");
            conn.commit();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Fallo en la operación, entrando en el roll-back");
            try {
                conn.rollback();
            } catch (SQLException ex1) {
                ex.printStackTrace(System.out);
            }
        }
        
        var usuarios= usuarioTest.seleccionar();
        imprimir(usuarios);
        

    }

    public static void imprimir(List<Usuario> usuarios) {
        usuarios.forEach(usuario -> {
            System.out.println("usuario = " + usuario);
        });
    }
}
