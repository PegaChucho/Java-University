package test;

import domain.*;

public class TestInstanceOf {

    public static void main(String[] args) {
        Empleado empleado1 = new Empleado("Silvia", 5000.00);
        determinarTipo(empleado1);

        empleado1 = new Gerente("Jesús", 16000.00, "Cloud Engineerig");
        //determinarTipo(empleado1);
    }

    public static void determinarTipo(Empleado empleado) {
        if (empleado instanceof Gerente) {
            System.out.println("Es de tipo gerente");
            //((Gerente) empleado).getDepartamento();// conversión de objeto
            Gerente gerente = (Gerente) empleado;
            System.out.println("gerente = " + gerente.getDepartamento());
        } else if (empleado instanceof Empleado) {
            System.out.println("Es de tipo Empleado");
//            Gerente gerente = (Gerente) empleado;
//            System.out.println("gerente = " + gerente.getDepartamento());
/*
No se pueden acceder a los metodos de arriba porque no existen en la clase
padre, solo en la clase hija
*/
            System.out.println("empleado = " + empleado.getNombre());
        } else if (empleado instanceof Object) {
            System.out.println("Es de tipo Object");
        } else {
            System.out.println("No es un objeto");
        }
    }
}
