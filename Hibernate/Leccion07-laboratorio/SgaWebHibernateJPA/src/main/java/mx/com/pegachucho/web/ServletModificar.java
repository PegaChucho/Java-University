package mx.com.pegachucho.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.com.pegachucho.domain.Alumno;
import mx.com.pegachucho.domain.Contacto;
import mx.com.pegachucho.domain.Domicilio;
import mx.com.pegachucho.servicio.ServicioAlumno;

@WebServlet(name = "ServletModificar", urlPatterns = {"/ServletModificar"})
public class ServletModificar extends HttpServlet {

    ServicioAlumno sa = new ServicioAlumno();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Recuperamos información
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        Integer idAlumno = Integer.parseInt(request.getParameter("idAlumno"));

        Alumno alumno = new Alumno();
        alumno.setIdAlumno(idAlumno);

        alumno = sa.encontrarAlumno(alumno); //se recupera toda la nfo de ese alumno

        //request.setAttribute("alumno", alumno);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("alumno", alumno);

        request.getRequestDispatcher("/WEB-INF/modificarAlumno.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Enviamos información
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        String modificar = request.getParameter("modificar");

        if (modificar != null) {

            response.setContentType("text/html;charset=UTF-8");
            request.setCharacterEncoding("UTF-8");

            String nombre = request.getParameter("nombre");//el name de los inputs
            String apellido = request.getParameter("apellido");
            String calle = request.getParameter("calle");
            String noCalle = request.getParameter("noCalle");
            int cp = Integer.parseInt(request.getParameter("cp"));
            String pais = request.getParameter("pais");
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");

            HttpSession sesion = request.getSession();
            Alumno alumno = (Alumno) sesion.getAttribute("alumno");

            alumno.setNombre(nombre);
            alumno.setApellido(apellido);
            alumno.getDomicilio().setCalle(calle);
            alumno.getDomicilio().setNoCalle(noCalle);
            alumno.getDomicilio().setCp(cp);
            alumno.getDomicilio().setPais(pais);
            alumno.getContacto().setEmail(email);
            alumno.getContacto().setTelefono(telefono);

            ServicioAlumno sa = new ServicioAlumno();
            sa.guardarAlumno(alumno);

            sesion.removeAttribute("alumno");//Vaciamos la inf del alcance de sesion

        } else {
            //caso de eliminar
            Integer idAlumno = Integer.parseInt(request.getParameter("idAlumno"));
            Alumno alumno = new Alumno(idAlumno);

            sa.eliminarAlumno(alumno);
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
