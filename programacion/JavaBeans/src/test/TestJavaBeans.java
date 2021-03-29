
package test;

import domain.Persona;

public class TestJavaBeans {
    public static void main(String[] args) {
        Persona persona1=new Persona();
        persona1.setNombre("Jesús");
        persona1.setApellido("Pérez");
        
        System.out.println("persona1 = " + persona1);
        System.out.println("persona1 nombre = " + persona1.getNombre());
        System.out.println("persona1 apellido = " + persona1.getApellido());
    }
}
