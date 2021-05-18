package web;

import datos.ClienteDAOJDBC;
import dominio.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarCliente(request, response);
                    break;
                case "eliminar":
                    this.eliminarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
                    break;
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "modificar":
                    this.modificarCliente(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
                    break;
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Cliente> clientes = new ClienteDAOJDBC().listar();
        System.out.println("clientes = " + clientes);
        HttpSession sesion = request.getSession();

        //Agregamos la coleccion de clientes al alcance request o sesion
        sesion.setAttribute("clientes", clientes);
        //Agregamos el tamaño de la colección, o lo que es lo mismo, el número de clientes
        sesion.setAttribute("totalClientes", clientes.size());
        //Calcular el Saldo total
        sesion.setAttribute("saldoTotal", calcularSaldoTotal(clientes));

        //Enviamos la información al JSP clientes, si utilizamos la primera ocion el alcance es request y en la segunda opciion el alcance es sesion
        //esto genera que el url no cambie pero se puede duplicar la información
        //request.getRequestDispatcher("clientes.jsp").forward(request, response);
        //se hace otra petición, asi que se pierde la info de request y response en el alcance request
        response.sendRedirect("clientes.jsp");
    }

    private double calcularSaldoTotal(List<Cliente> clientes) {
        double saldoTotal = 0;
        for (Cliente cliente : clientes) {
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }

    private void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Recuperamos los valores del forulario agregarClienteModal
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        //casteamos saldo al tipo número, ya que getparameter de
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !saldoString.equals("")) {
            saldo = Double.parseDouble(saldoString);
        }

        //Creamos el objeto de cliente(MVC ---> modelo)
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);

        //insertamos el nuevo objeto en la base de datos
        int registrosModificados = new ClienteDAOJDBC().insertar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);

        //redirigimos hacia la acción por default 
        this.accionDefault(request, response);
    }

    private void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //recuperamos el idCliente
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        //Busca e la base de datos al cliente por su id y recupera los demas valores en este objetoidCliente
        Cliente cliente = new ClienteDAOJDBC().encontrar(new Cliente(idCliente));
        request.setAttribute("cliente", cliente);
        
        String jspEditar="/WEB-INF/paginas/cliente/editarCliente.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
    
    private void modificarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Recuperamos los valores del forulario de editarCliente, el parámetro idCliente viene del URL
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");
        //casteamos saldo al tipo número, ya que getparameter de
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !saldoString.equals("")) {
            saldo = Double.parseDouble(saldoString);
        }

        //Creamos el objeto de cliente(MVC ---> modelo)
        Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);

        //modificamos el nuevo objeto en la base de datos
        int registrosModificados = new ClienteDAOJDBC().actualizar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);

        //redirigimos hacia la acción por default 
        this.accionDefault(request, response);
    }
    
    private void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Recuperamos los valores del forulario de editarCliente, el parámetro idCliente viene del URL
        int idCliente = Integer.parseInt(request.getParameter("idCliente"));
        
        //Creamos el objeto de cliente(MVC ---> modelo)
        Cliente cliente = new Cliente(idCliente);

        //Eliminamos el objeto en la base de datos
        int registrosModificados = new ClienteDAOJDBC().eliminar(cliente);
        System.out.println("registrosModificados = " + registrosModificados);

        //redirigimos hacia la acción por default 
        this.accionDefault(request, response);
    }

}
