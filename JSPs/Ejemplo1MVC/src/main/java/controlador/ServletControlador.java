package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
        
        //2.- Creamos los JavaBeans
        Rectangulo rec = new Rectangulo(3, 6);
        
        //3.- Agregamos el JavaBean a algun alcance (en este caso, request):
        request.setAttribute("mensaje", "Saludos desde el Servlet");
        
        HttpSession sesion= request.getSession();
        sesion.setAttribute("rectangulo", rec);
        
        //4.- Redireccionamos a la vista seleccionada y propagamos el request/response
        RequestDispatcher rd= request.getRequestDispatcher("vista/desplegarVariables.jsp");
        rd.forward(request, response);
        
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
