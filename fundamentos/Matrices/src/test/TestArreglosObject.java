package test;

import domain.Persona;

public class TestArreglosObject {

    public static void main(String[] args) {
        int j = 0;
        Persona personas[] = new Persona[2];

        personas[0] = new Persona("Jesus");
        personas[1] = new Persona("Silvia");

        for (Persona item : personas) {
            System.out.println("Persona = " + item);
        }

        for (int i = 0; i < personas.length; i++) {
            System.out.println("personas " + i + " = " + personas[i].getNombre());
        }

        String frutas[] = {"plátano", "manzana", "pera", "mamey", "calabaza"};
        for (String item : frutas) {
            j++;
            System.out.println("Fruta " + j + " = " + item);
        }

    }
}
