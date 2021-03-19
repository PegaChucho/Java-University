package test;

import domain.Persona;

public class TestMatrices {

    public static void main(String[] args) {
        int i = 0, j = 0;
        int edades[][] = new int[3][2];
        System.out.println("edades = " + edades);

        edades[0][0] = 5;
        edades[0][1] = 4;
        edades[1][0] = 7;
        edades[1][1] = 42;
        edades[2][0] = 6;
        edades[2][1] = 87;

        for (int[] u : edades) {
            for (int uu : u) {
                System.out.println("Elemento = " + uu);
            }
        }

        for (int ren = 0; ren < edades.length; ren++) {
            for (int col = 0; col < edades[ren].length; col++) {
                System.out.println("edades = " + ren + "-" + col + ": " + edades[ren][col]);
            }
        }

        String frutas[][] = {{"naranja", "limon"}, {"fresa", "zarzamora", "mora"}};
        for (String[] u : frutas) {
            for (String uu : u) {
                System.out.println("Fruta = " + uu);
            }
        }

        Persona personas[][] = new Persona[2][3];
        personas[0][0] = new Persona("Jesús");
        personas[0][1] = new Persona("Silvia");
        personas[0][2] = new Persona("Eva");
        personas[1][0] = new Persona("Luz");
        personas[1][1] = new Persona("Valentín");
        personas[1][2] = new Persona("Rogelio");
        
        imprimir(personas);

    }

    public static void imprimir(Object matriz[][]) {
        for (int ren = 0; ren < matriz.length; ren++) {
            for (int col = 0; col < matriz[ren].length; col++) {
                System.out.println("Elemento = " + ren + "-" + col + ": " + matriz[ren][col]);
            }
        }
    }
}
