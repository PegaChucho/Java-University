package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        //se recuperan los elemenos del formulario uno a uno
        String usuario = request.getParameter("usuario");//name="usuario en el HTML ...
        String password = request.getParameter("password");
        String tecnologias[] = request.getParameterValues("tecnologia"); //varios elementos
        String genero = request.getParameter("genero");
        String ocupacion = request.getParameter("ocupacion");
        String generosMusicales[] = request.getParameterValues("musica");
        String comentario = request.getParameter("comentarios");

        out.print("<html>");
        out.print("<head>");
        out.print("<title>Resultado Servlet</title>");
        out.print("</head>");
        out.print("<body>");
        out.print("<h1>Parámetros procesados por el Servlet</h1>");
        out.print("<table border='1'>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Usuario");
        out.print("</td>");
        out.print("<td>");
        out.print(usuario);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Password");
        out.print("</td>");
        out.print("<td>");
        out.print(password);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Tecnologías");
        out.print("</td>");
        out.print("<td>");
        for (String tecnologia : tecnologias) {
            out.print(tecnologia);
            out.print(" / ");
        }
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Género");
        out.print("</td>");
        out.print("<td>");
        out.print(genero);
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Ocupación");
        out.print("</td>");
        out.print("<td>");
        switch (ocupacion) {
            case "1":
                out.print("Profesor");
                break;
            case "2":
                out.print("Ingeniero");
                break;
            case "3":
                out.print("Jubilado");
                break;
            case "4":
                out.print("Otro");
                break;
        }
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Misica que le gusta");
        out.print("</td>");
        out.print("<td>");
        if (generosMusicales != null) {
            for (String generoMusical : generosMusicales) {
                out.print(generoMusical);
                out.print(" / ");
            }
        }else{
            out.print("No se seleccionó ningún género");
        }
        out.print("</td>");
        out.print("</tr>");

        out.print("<tr>");
        out.print("<td>");
        out.print("Comentario");
        out.print("</td>");
        out.print("<td>");
        out.print(comentario);
        out.print("</td>");
        out.print("</tr>");

        out.print("</table");
        out.print("</body");
        out.print("</html");
    }
}
