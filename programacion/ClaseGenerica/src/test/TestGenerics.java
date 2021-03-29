package test;

import genericos.ClaseGenerica;

public class TestGenerics {
    public static void main(String[] args) {
        ClaseGenerica<Integer> objetoInt= new ClaseGenerica(23);
        objetoInt.obtenerTipo();
        
        ClaseGenerica<String> objetoStr= new ClaseGenerica("Jordan");
        objetoStr.obtenerTipo();
    }
}
