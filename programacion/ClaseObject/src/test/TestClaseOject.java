package test;

import domain.*;

public class TestClaseOject {
    public static void main(String[] args) {
        Empleado empleado1= new Empleado("Jesús", 16000);
        Empleado empleado2= new Empleado("Jesús", 16000);
        
        if (empleado1 == empleado2){
            System.out.println("Misma referencia en memoria");
        } else{
            System.out.println("Tienen distinta referencia");
        }
        
       if ( empleado1.equals(empleado2)){
           System.out.println("Los objetos son iguales en contenido");
       } else {
           System.out.println("Los objetos son diferentes en contenido");
       }
       
       if(empleado1.hashCode()== empleado2.hashCode()){
           System.out.println("El valor hashCode es igual");
       } else {
           System.out.println("El valor hashCode es distinto");
       }
    }
}
