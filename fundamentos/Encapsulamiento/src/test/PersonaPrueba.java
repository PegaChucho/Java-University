package test;
import dominio.Persona;

public class PersonaPrueba {
    public static void main(String[] args) {
        Persona persona1= new Persona("Jesús", 16000.00, false);
        persona1.setSueldo(12000.00);
        //persona1.nombre="Oscar"; //ya no se puede por que es un atributo privado
        //System.out.println("nombre: " + persona1.nombre);
        //System.out.println("nombre: " + persona1.getNombre());
        //System.out.println("sueldo: " + persona1.getSueldo());
        //System.out.println("eliminado: " + persona1.isEliminado());
        System.out.println(persona1);
    }
}
