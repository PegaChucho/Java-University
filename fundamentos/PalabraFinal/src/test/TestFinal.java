package test;

import domain.Persona;

public class TestFinal {

    public static void main(String[] args) {
        final int miVariable = 10;
        System.out.println("miVariable = " + miVariable);

        final Persona persona1 = new Persona();// la variable persona1 ya no se le puede asignar otro objeto
        persona1.setNombre("Jesús");
        System.out.println("persona1 = " + persona1.getNombre());
        //persona1 = new Persona();

        //Persona.CONSTANTE=10;
        //miVariable=11;
    }
}
