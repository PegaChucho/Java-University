package web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/GeneracionExcelServlet")
public class GeneracionExcelServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
            //indicar tipo de respuesa al navegador
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=excelEjemplo.xls");
            //para un uso mas profesional de documentos de microsoft, usar Apache POI
            
            //indicar al navegador que no guarde cache
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setDateHeader("Expires", -1);
            
            //desplegar información al cliente
            PrintWriter out = response.getWriter();
            //aqui si se debe de usar println
            out.println("\tValores");
            out.println("\t1");
            out.println("\t2");
            out.println("Total\t=SUM(b2:b3)");
            out.close();    
        }
        
}
