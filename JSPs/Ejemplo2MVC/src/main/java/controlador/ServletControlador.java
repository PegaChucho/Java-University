package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Rectangulo;

@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1.- Procesamos los parámetros
        String accion= request.getParameter("accion");
        
        //2.- Creamos los JavaBeans
        Rectangulo recRequest = new Rectangulo(1, 2);
        Rectangulo recSesion = new Rectangulo(3, 4);
        Rectangulo recAplicacion = new Rectangulo(5, 6);
        
        //3.- Agregamos el JavaBean a algun alcance (en este caso, request):
        //Revisamos la acción
        if ("agregaVariables".equals(accion)) {
            //alcance de request
            request.setAttribute("rectanguloRequest", recRequest);
            //alcance session
            HttpSession sesion = request.getSession();
            sesion.setAttribute("rectanguloSesion", recSesion);
            //alcance aplication
            ServletContext application = this.getServletContext();
            application.setAttribute("rectanguloAplicacion", recAplicacion);
            
            //Agregamos un mensaje
            request.setAttribute("mensaje", "las variables fueron agregadas");
            
            //4.- Redireccionamos a index una vez cargadas las variablese
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
        }else if ("listarVariables".equals(accion)) {
            //4.- Redireccionamos a la vista seleccionada y propagamos el request/response
            request.getRequestDispatcher("WEB-INF/alcanceVariables.jsp").forward(request, response);
        }else {
            //Redireccionamos a la página de inicio
            request.setAttribute("mensaje", "Acción desconocida");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
            //Sirve tambien para redireccionar pero no de puede propagar el request/response y no agregaria info
            //response.sendRedirect("index.jsp");
        }
        
        

        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
