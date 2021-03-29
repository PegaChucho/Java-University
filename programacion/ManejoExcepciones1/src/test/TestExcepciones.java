
package test;

import static aritmetica.Aritmetica.división;
import excepciones.OperacionExcepcion;

public class TestExcepciones {
    public static void main(String[] args) {
        double resultado=0;
        try{
            resultado = división(432.22, 0);
        }catch(OperacionExcepcion e){ //menor jerarquía
            System.out.println("Ocurrió un error del tipo operación excepción: ");
        }catch(Exception e){
            System.out.println("Ocurrió un error de tipo exception: ");
            e.printStackTrace(System.out);
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Se realizó la división entre 0");
        }
        
        System.out.println("resultado = " + resultado);
    }
}
