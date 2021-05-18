package datos;

import domain.*;
import java.sql.*;
import java.util.*;

public interface IPersonaDAO {

    public List<PersonaDTO> listar() throws SQLException;

    public int insertar(PersonaDTO persona) throws SQLException;

    public int borrar(PersonaDTO persona) throws SQLException;

    public int actualizar(PersonaDTO persona) throws SQLException;

}
