package test;

import operaciones.Operaciones;

public class TestOperaciones {
    public static void main(String[] args) {
        var resultado = Operaciones.sumar(5, 4);
        System.out.println("resultado = " + resultado);
        
        var resultado1 = Operaciones.sumar(5.5, 4.8);
        System.out.println("resultado1 = " + resultado1);
        
        var resultado2 = Operaciones.sumar(25, 27L);
        System.out.println("resultado2 = " + resultado2);
        
        var resultado3 = Operaciones.sumar(6, 4D);
        System.out.println("resultado3 = " + resultado3);
    }
}
