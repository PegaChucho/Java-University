
package PasoPorReferencia;

import clases.Persona;


public class PasoPorReferencia {

    public static void main(String[] args) {

        Persona persona1 = new Persona();
        persona1.nombre = "Valentín";
        System.out.println("persona1 nombre = " + persona1.nombre);

        cambiarValor(persona1);
        System.out.println("persona1 nuevonombre = " + persona1.nombre);
        
        persona1= cambiarValorReturn(persona1);
        System.out.println("persona1 = " + persona1.nombre);
    }

    //persona recibe la referencia del objeto persona1 del método main
    public static void cambiarValor(Persona persona) {
        persona.nombre = "Eva";
    }
    
    public static Persona cambiarValorReturn(Persona persona) {
        persona.nombre = "Lucero";
        return persona;
    }

}
