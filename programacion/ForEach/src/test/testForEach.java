package test;

import domain.Persona;

public class testForEach {

    public static void main(String[] args) {

        int edades[] = {5, 6, 3, 1, 9};

//        for (int i = 0; i < edades.length; i++) {
//            System.out.println("edad " +(i+1)+"= "+ edades[i]);
//        }
        for (int item : edades) {
            System.out.println("edad = " + item);
        }

        Persona personas[] = {new Persona("Jesús"), new Persona("Eva"),
            new Persona("Valentín"), new Persona("Lucero"), 
            new Persona("Silvita")};
        
        for (Persona persona:personas){
            System.out.println("persona = " + persona);
        }

    }
}
