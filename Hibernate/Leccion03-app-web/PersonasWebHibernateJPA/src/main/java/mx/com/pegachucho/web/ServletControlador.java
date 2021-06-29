
package mx.com.pegachucho.web;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.pegachucho.domain.Persona;
import mx.com.pegachucho.servicio.ServicioPersonas;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
    
    @Override 
    protected void doGet(HttpServletRequest request, HttpServletResponse response){
        try {
            ServicioPersonas sp = new ServicioPersonas();
            
            List<Persona> personas = sp.listarPersonas();
            
            request.setAttribute("personas", personas);
            request.getRequestDispatcher("/WEB-INF/listado.jsp").forward(request, response);
        } catch (ServletException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
}
