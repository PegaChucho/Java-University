/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.pegachucho.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.pegachucho.domain.Alumno;
import mx.com.pegachucho.domain.Contacto;
import mx.com.pegachucho.domain.Domicilio;
import mx.com.pegachucho.servicio.ServicioAlumno;

@WebServlet(name = "ServletAgregar", urlPatterns = {"/ServletAgregar"})
public class ServletAgregar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

        Domicilio domicilio = new Domicilio();
        domicilio.setCalle(calle);
        domicilio.setNoCalle(noCalle);
        domicilio.setCp(cp);
        domicilio.setPais(pais);

        Contacto contacto = new Contacto();
        contacto.setEmail(email);
        contacto.setTelefono(telefono);

        Alumno alumno = new Alumno();
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);

        ServicioAlumno sa = new ServicioAlumno();
        sa.guardarAlumno(alumno);

        request.getRequestDispatcher("/index.jsp").forward(request, response);

    }

}
