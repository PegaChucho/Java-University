package test;

import domain.Cliente;
import domain.Empleado;
import java.util.Date;



public class TestHerencia {
    public static void main(String[] args) {
        
        Date fecha = new Date();
        
        Empleado empleado1= new Empleado("Jesús Pérez", 16000.00);
        System.out.println("empleado1 = " + empleado1);
        
//        Cliente cliente1 =  new Cliente(new Date(), true, "Silvia Orozco", 
//                'F', 27, "Cerca de la villa");
//                System.out.println("cliente1 = " + cliente1);
                
//        Cliente cliente2 =  new Cliente(fecha, true, "Eva García", 
//                'F', 27, "Cerca de la villa");
//                System.out.println("cliente2 = " + cliente2);

    }
  
}
