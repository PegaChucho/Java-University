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
public class PruebaAritmetica {
    public static void main(String[] args) {
        //VARIABLES LOCALES
        int a=10, b=2;
        
        Aritmetica aritmetica1= new Aritmetica();
        System.out.println("aritmetica1 a = " + aritmetica1.a);
        System.out.println("aritmetica1 b = " + aritmetica1.b);
        
        Aritmetica aritmetica2= new Aritmetica(6, 9);
        aritmetica2.sumar();
        miMetodo();

        
    }
    
    public static void miMetodo(){
        //variables fuera del alcance de main
        //a=101;
        System.out.println("otro método");
    }
}
