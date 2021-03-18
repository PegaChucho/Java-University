/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasoporvalor;

/**
 *
 * @author jperezgarcia
 */
public class PasoPorValor {
    public static void main(String[] args) {
        var x=10;
        System.out.println("x = " + x);
        
        cambioValor(x);
        
        System.out.println("x nuevo valor = " + x);
    }
    
    //paso por valor de x => arg1
    public static void cambioValor(int arg1){
        System.out.println("arg1 = " + arg1);
        arg1=15;
    }
}
