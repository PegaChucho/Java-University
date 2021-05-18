package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        //Recuperamos (o creamos) el objeto HttpSession
        HttpSession sesion = request.getSession();

        //recuperamos la lista de articulos previamente agregados
        List<String> articulos = (List<String>) sesion.getAttribute("articulos");

        //Verificamos si la lista existe
        if (articulos == null) {
            //inicializamos la lista de articulos
            articulos = new ArrayList<>();
            sesion.setAttribute("articulos", articulos);
        }

        //procesamos el nuevo artículo
        String articuloNuevo = request.getParameter("articulo");

        //revisamos y agregamos el articulo nuevo
        if (articuloNuevo != null && !articuloNuevo.trim().equals("")) {
            articulos.add(articuloNuevo);
        }

        try ( //imprimimos la lista de articulos
                 PrintWriter out = response.getWriter()) {
            out.print("<h1>Lista de articulos</h1>");
            out.print("<br>");

            //iteramos todos los articulos
            for (String articulo : articulos) {
                out.print("<li>" + articulo + "</li>");
            }

            //Agregamos un link para regresar al inicio
            out.print("<br>");
            out.print("<a href='/EjemploCarritoCompras'>Regresar al inicio</a>");
        }//try with resources, va a cerrar el código
    }
}
