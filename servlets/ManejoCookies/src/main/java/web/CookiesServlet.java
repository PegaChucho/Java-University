package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CookiesServlet")
public class CookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Suponemos que el usuario visita por primera vez el sitio
        boolean nuevoUsuario = true;

        //Obtenemos el arreglo de cookies
        Cookie[] cookies = request.getCookies();

        //buscamos si ya existe una Cookie creada anteriormente llamada visitanterecurrente
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitanteRecurrente") && c.getValue().equals("si")) {;
                    //si ya xiste la cookie es un usuaro recurrente
                    nuevoUsuario = false;
                    break;
                }
            }
        }

        //agregamos la cookie en la respuesta para que ya no sea un 
        String msj = null;
        if (nuevoUsuario) {
            Cookie visitanteCookie = new Cookie("visitanteRecurrente", "si");
            response.addCookie(visitanteCookie);
            msj = "Gracias por visitar nuestro sitio por primera vez";
        } else {
            msj = "Gracias por visitar nuevamente nuestro sitio";
        }

        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(msj);
        out.close();

    }
}
