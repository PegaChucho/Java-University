package testclientews;

import clientews.servicio.ServicioSumarImplService;
import clientews.servicio.ServicioSumarWS;

public class TestServicioSumarWS {
    public static void main(String[] args) {
        ServicioSumarWS servicioSumar= new ServicioSumarImplService().getServicioSumarImplPort();
        System.out.println("Ejecutando servicio sumarWS");
        int x=6;
        int y=9;
        int resultado=servicioSumar.sumar(x, y);
        System.out.println("Resultado = " + resultado);
        System.out.println("Fin del servicio sumarWS");
    }
}
