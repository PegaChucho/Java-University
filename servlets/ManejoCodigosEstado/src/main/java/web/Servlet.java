
package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet{
    
    @Override
    protected void doPost( HttpServletRequest request,HttpServletResponse response) throws IOException{
        //simulando valores correctos
        String usuarioOk ="Jesus";
        String passwordOk ="123";
        
        String usuario=request.getParameter("usuario");
        String password=request.getParameter("password");
        
        PrintWriter out= response.getWriter();
        
        if (usuarioOk.equals(usuario) && passwordOk.equals(password)) {
            out.print("<h1>");
            out.print("Datos correctos");
            out.print("<br>");
            out.print("Usuario: "+ usuario);
            out.print("<br>");
            out.print("Password: "+ password);
            out.print("</h1>");
        }else{
            response.sendError(response.SC_UNAUTHORIZED, "las credenciales son incorrectas");
        }
    }
}
