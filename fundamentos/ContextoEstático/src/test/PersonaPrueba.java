package test;

import domain.Persona;


public class PersonaPrueba {
private int contador;


    public static void main(String[] args) {
        Persona persona1 = new Persona("Jesús Pérez");
        Persona persona2 = new Persona("Silvia Orozco");
        
        imprimir(persona1);
        imprimir(persona2);
        
    }
    
    public static void imprimir(Persona persona){
        System.out.println("persona = " + persona);
    }
    
    public int getContador(){
        imprimir(new Persona("Eva García"));
        return this.contador;
    }
}
