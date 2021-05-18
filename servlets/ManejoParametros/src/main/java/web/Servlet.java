package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //leer los parámetros del formulario html
        String usuario= request.getParameter("usuario");
        String password= request.getParameter("password");
        System.out.println("usuario = " + usuario);
        System.out.println("password = " + password);
        
        PrintWriter out=response.getWriter();
        out.print("<html>");
        out.print("<body>");
        out.print("El parámetro usuario es: "+usuario);
        out.print("<br>");
        out.print("El parámetro password es: "+password);
        out.print("</body>");
        out.print("</html>");
        out.close();
        
    }
}
