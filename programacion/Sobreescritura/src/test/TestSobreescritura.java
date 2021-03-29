package test;

import domain.*;

public class TestSobreescritura {

    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Silvia", 5000.00);
//        System.out.println("empleado1 = " + empleado1.obtenerDetalles
        imprimir(empleado1);

        Gerente gerente1 = new Gerente("Jesús", 16000.00, "Cloud Engineerig");
        //empleado=new Gerente("Jesús", 16000.00, "Cloud Engineerig"); 
        /*
        Como la variable empleado es del tipo empleado, esta puede sin problemas
        guardar objetos del tipo gerente.
        */
//        System.out.println("gerente1 = "+ gerente1.obtenerDetalles());
        imprimir(gerente1);
    }

    public static void imprimir(Empleado empleado) {
        String detalles= empleado.obtenerDetalles();
        System.out.println("empleado = " + detalles);
    }
}
