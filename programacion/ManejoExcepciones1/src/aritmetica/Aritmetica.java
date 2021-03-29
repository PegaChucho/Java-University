package aritmetica;

import excepciones.OperacionExcepcion;

public class Aritmetica {

    public static double división(double numerador, double denominador)
            throws OperacionExcepcion {//firma del metodo, necesaria si extiende de exception
        if (denominador == 0) {
            throw new OperacionExcepcion("División entre 0");
        }
        
        return numerador/denominador;
    }
}
