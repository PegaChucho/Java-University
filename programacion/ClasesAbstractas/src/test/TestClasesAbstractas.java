
package test;

import domain.*;


public class TestClasesAbstractas {
    public static void main(String[] args) {
        FiguraGeometrica figura= new Rectangulo("Rectángulo"); //upcasting, tipo hijo a um tipo padre
        figura.dibujar();
    }
    
}
