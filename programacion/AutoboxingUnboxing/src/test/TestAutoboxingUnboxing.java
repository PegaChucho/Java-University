
package test;

public class TestAutoboxingUnboxing {
    public static void main(String[] args) {
        //Clases envolventes de tipos primitivos
        /*
        int-Integer
        long-Long
        float-Float
        double-Double
        boolean-Boolean
        byte-Byte
        char-Character
        short-Short
        */
        
        int entero=10;
        Integer entero2=20;
        System.out.println("entero2 = " + entero2);
        System.out.println("entero2 = " + entero2.toString());
        System.out.println("entero2 = " + entero2.doubleValue());
        
        int entero3=entero2;//unboxing, se recupera el valor de entero2
        System.out.println("entero3 = " + entero3);
    }
}
