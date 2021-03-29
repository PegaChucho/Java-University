package test;

import enumeracion.Continentes;
import enumeracion.Dias;

public class TestEnumeraciones {

    public static void main(String[] args) {
//        System.out.println("Dia 1 = " + Dias.LUNES);
//
//        indicarDia(Dias.LUNES);
        System.out.println("Continente no.4: "+ Continentes.EUROPA);
        System.out.println("Numero paises no.4: "+
                Continentes.EUROPA.getPaises() +
                ", habitantes: " + Continentes.EUROPA.getHabitantes());

    }

    private static void indicarDia(Dias dias) {
        switch (dias) {
            case LUNES, MARTES, MIERCOLES, JUEVES, VIERNES:
                System.out.println("Entre semana");
                break;
            default:
                System.out.println("Fin de semana");

        }
    }
}
