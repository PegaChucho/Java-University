package paquete1;

import paquete1.Clase1;
import paquete1.ClaseHija;

public class TestModificadoresAcceso {

    public static void main(String[] args) {
        Clase1 clase1 = new Clase1("Cadena");
        System.out.println("clase1 = " + clase1.getAtributoprivado());
//        clase1.atributoDefault = "Kagabonga";
//
//        clase1.metodoPublico();

    }
}
