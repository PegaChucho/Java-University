package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/HoraServlet")
public class HoraServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException{
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("refresh", "1");
        Date fecha = new Date();
        SimpleDateFormat formateador= new SimpleDateFormat("'Hora actualizada' HH:mm:ss");
        String horaFormateada= formateador.format(fecha);
        
        PrintWriter out = response.getWriter();
        out.print(horaFormateada);
    }
}
