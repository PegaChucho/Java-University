package test;

import domain.*;

public class TestConversionObjetos {

    public static void main(String[] args) {
        Empleado empleado;

        empleado = new Escritor("Silvia", 5000.00, TipoEscritura.CLASICO);
        //System.out.println("empleado = " + empleado);

        //System.out.println(empleado.obtenerDetalles());

        //downcasting
        //((Escritor)empleado).getTipoEscritura(); //no existe en el tipo empleado
        Escritor escritor = (Escritor) empleado;
        escritor.getTipoEscritura();

        //upcasting
        Empleado empleado2 = escritor;
        System.out.println(empleado2.obtenerDetalles());
                
    }
}
