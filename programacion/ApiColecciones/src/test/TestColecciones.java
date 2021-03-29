package test;

import java.util.*;

public class TestColecciones {

    public static void main(String[] args) {
        List miLista = new ArrayList();//tipo lista
        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");
        miLista.add("Sábado");
        miLista.add("Domingo");
        //imprimir(miLista);

        Set miSet = new HashSet();
        miSet.add("Lunes");
        miSet.add("Martes");
        miSet.add("Miercoles");
        miSet.add("Jueves");
        miSet.add("Viernes");
        miSet.add("Sábado");
        miSet.add("Domingo");
        //imprimir(miSet);
        
        Map miMap = new HashMap();
        miMap.put("valor1", "Jesús");
        miMap.put("valor2", "Silvia");
        miMap.put("valor3", "Eva");
        
        String elemento= (String) miMap.get("valor2");
        System.out.println("elemento = " + elemento);
        
        imprimir(miMap.keySet()); //regresa el set de llaves y lo podemos recorrer
        imprimir(miMap.values()); //regresa los valores
    }

    public static void imprimir(Collection coleccion) {
//        for (var item : coleccion) {
//            System.out.println("item = " + item);
//        }
        coleccion.forEach(item -> {
            System.out.println("item = " + item);
        });
    }
}
