/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

/**
 *
 * @author jperezgarcia
 */
public class Aritmetica {//se recomienda que las clases comiencen con mayúsculas

    int a, b;//atributos

    //constructor vacío
    public Aritmetica() {
        System.out.println("Ejecutando constructor");
    }

    public Aritmetica(int a, int b) {
        this.a = a;
        this.b = b;
                System.out.println("Ejecutando constructor con argumentos");

    }

    //metido
    public void sumar() {
        int resultado = a + b;
        System.out.println("resultado = " + resultado);
    }

    public int sumarRetorno() {
        int resultado = a + b;
        return resultado;// return a+b;
    }

    public int sumarArgs(int a, int b) {
        this.a = a;
        this.b = b;
        return this.a + this.b;
    }
}
