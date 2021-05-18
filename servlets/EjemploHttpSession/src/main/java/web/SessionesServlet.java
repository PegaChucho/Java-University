package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/SesionesServlet")
public class SessionesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset-UTF-8");

        HttpSession sesion = request.getSession();//se crea una sesión si no existe una

        String titulo = null;

        //Pedir el atrubuto contador visitas a la sesión
        Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");
        //Si es nulo es la primera vez que accedemos a la aplicacion
        if (contadorVisitas == null) {
            contadorVisitas = 1;
            titulo = "Bienvenido por primera vez";
        } else {
            contadorVisitas++;
            titulo = "Bienvenido de nuevo";
        }

        //agregamos el nuevo valor a la sesion
        sesion.setAttribute("contadorVisitas", contadorVisitas);

        //mandamos la respuesta al cliente
        PrintWriter out = response.getWriter();
        out.print(titulo);
        out.print("<br>");
        out.print("No. de accesos al recurso: " + contadorVisitas);
        out.print("<br>");
        out.print("ID de la sesión: " + sesion.getId());
        out.close();
    }
}
