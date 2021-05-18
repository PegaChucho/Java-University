package datos;

import dominio.Cliente;
import java.sql.*;
import java.util.*;

public class ClienteDAOJDBC {

    private static final String SQL_SELECT = "SELECT id_cliente, nombre, apellido, email, telefono, saldo "
            + "FROM cliente";

    private static final String SQL_SELECT_BY_ID = "SELECT id_cliente, nombre, apellido, email, telefono, saldo "
            + "FROM cliente WHERE id_cliente = ?";

    private static final String SQL_INSERT = "INSERT INTO cliente (nombre, apellido, email, telefono, saldo) "
            + "VALUES(?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE cliente "
            + "SET nombre=?, apellido=?, email=?, telefono=?, saldo=? WHERE id_cliente=?";

    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente=?";

    public List<Cliente> listar() {
        //inicializamos las variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            //crea la conexión
            conn = Conexion.getConnection();
            //prepara la consulta
            stmt = conn.prepareStatement(SQL_SELECT);
            //ejecuta la consulta y la guarda en rs
            rs = stmt.executeQuery();

            //recuperamos los datos del objeto rs, next recorre las filas de datos
            //y cuando no haya mas , va a regresar un false
            while (rs.next()) {
                int idCliente = rs.getInt("id_cliente");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getDouble("saldo");

                //creamos un objeto cliente con la info recuperada de rs
                cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //cerramos las variables en el orden inverso al que las abrimos
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return clientes;
    }

    public Cliente encontrar(Cliente cliente) {
        //inicializamos las variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            //crea la conexión
            conn = Conexion.getConnection();
            //prepara la consulta
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            //setInt sirve para sustituir a los argumentos en la consulta "...SQL id_cliente = ?"
            //El 1 significa que la consulta tiene un argumento y el otro parametro es lo que se va a sustituir
            stmt.setInt(1, cliente.getIdCliente());
            //ejecuta la consulta y la guarda en rs
            rs = stmt.executeQuery();
            //nos posicionamos en el primer registro devuelto
            rs.next();

            //recuperamos los datos del objeto rs, next recorre las filas de datos
            //y cuando no haya mas , va a regresar un false
            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            double saldo = rs.getDouble("saldo");

            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            cliente.setSaldo(saldo);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //cerramos las variables en el orden inverso al que las abrimos
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return cliente;
    }

    public int insertar(Cliente cliente) {
        //inicializamos las variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            //crea la conexión
            conn = Conexion.getConnection();
            //prepara la consulta y sustituye parámetros ???
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());

            //ejecuta el update y regresa el número de elementos modificados
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //cerramos las variables en el orden inverso al que las abrimos
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    public int actualizar (Cliente cliente){
         //inicializamos las variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            //crea la conexión
            conn = Conexion.getConnection();
            //prepara la consulta y sustituye parámetros ???
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            stmt.setInt(6, cliente.getIdCliente());

            //ejecuta el update y regresa el número de elementos modificados
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //cerramos las variables en el orden inverso al que las abrimos
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
    
    public int eliminar (Cliente cliente){
         //inicializamos las variables
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            //crea la conexión
            conn = Conexion.getConnection();
            //prepara la consulta y sustituye parámetros ???
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getIdCliente());

            //ejecuta el update y regresa el número de elementos modificados
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            //cerramos las variables en el orden inverso al que las abrimos
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }
}
