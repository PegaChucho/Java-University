/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author jperezgarcia
 */
public class PruebaPersona {
    public static void main(String[] args) {
        Persona persona1= new Persona();
        Persona persona2= new Persona();

        persona1.nombre="Jesús";
        persona1.apellido= "Pérez";
        
        persona1.desplegarInfo();
        System.out.println("persona1 = " + persona1);
        System.out.println("persona2 = " + persona2);
    }
}
