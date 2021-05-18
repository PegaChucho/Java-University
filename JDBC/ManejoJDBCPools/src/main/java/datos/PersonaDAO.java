package datos;

import domain.PersonaDTO;
import java.sql.*;
import java.util.*;
import static datos.Conexion.*;

public class PersonaDAO implements IPersonaDAO {

    private Connection connTransaccional;

    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, mail, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona(nombre, apellido, mail, telefono) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=?, mail=?, telefono=? WHERE (id_persona = ?)";
    private static final String SQL_DELETE = "DELETE FROM persona where id_persona=?";

    public PersonaDAO() {
    }

    public PersonaDAO(Connection connTransaccional) {
        this.connTransaccional = connTransaccional;
    }

    public List<PersonaDTO> listar() throws SQLException {
        /*
        Se inicializan las siguentes variables para que queden fuera del bloque try catch y puedan ser 
        utilizadas fuera de ese bloque.
         */
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonaDTO persona = null;
        List<PersonaDTO> personas = new ArrayList<>();

        try {
            conn = this.connTransaccional != null ? this.connTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("mail");
                String telefono = rs.getString("telefono");

                persona = new PersonaDTO(idPersona, nombre, apellido, email, telefono);

                personas.add(persona);
            }
        } finally {
            try {
                close(rs, stmt);
                if (this.connTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return personas;
    }

    public int insertar(PersonaDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.connTransaccional != null ? this.connTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());//1-nombre, 2-apellido,  3-mail, 4-telefono
            stmt.setString(2, persona.getApellido());//1-nombre, 2-apellido,  3-mail, 4-telefono
            stmt.setString(3, persona.getMail());//1-nombre, 2-apellido,  3-mail, 4-telefono
            stmt.setString(4, persona.getTelefono());//1-nombre, 2-apellido,  3-mail, 4-telefono
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.connTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int actualizar(PersonaDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.connTransaccional != null ? this.connTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());//1-nombre, 2-apellido,  3-mail, 4-telefono
            stmt.setString(2, persona.getApellido());//1-nombre, 2-apellido,  3-mail, 4-telefono
            stmt.setString(3, persona.getMail());//1-nombre, 2-apellido,  3-mail, 4-telefono
            stmt.setString(4, persona.getTelefono());//1-nombre, 2-apellido,  3-mail, 4-telefono
            stmt.setInt(5, persona.getIdPersona());//1-nombre, 2-apellido,  3-mail, 4-telefono
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.connTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public int borrar(PersonaDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = this.connTransaccional != null ? this.connTransaccional : getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());//1-nombre, 2-apellido,  3-mail, 4-telefono
            registros = stmt.executeUpdate();
        } finally {
            try {
                close(stmt);
                if (this.connTransaccional == null) {
                    close(conn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

}
