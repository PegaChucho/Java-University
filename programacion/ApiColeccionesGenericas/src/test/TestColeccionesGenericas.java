package test;

import java.util.*;

public class TestColeccionesGenericas {

    public static void main(String[] args) {
        List<String> miLista = new ArrayList<>();//tipo lista
        miLista.add("Lunes");
        miLista.add("Martes");
        miLista.add("Miercoles");
        miLista.add("Jueves");
        miLista.add("Viernes");
        miLista.add("Sábado");
        miLista.add("Domingo");
        String elementoStr= miLista.get(0);
        //System.out.println("elementoStr = " + elementoStr);
        //imprimir(miLista);

        Set<String> miSet = new HashSet<>();
        miSet.add("Lunes");
        miSet.add("Martes");
        miSet.add("Miercoles");
        miSet.add("Jueves");
        miSet.add("Viernes");
        miSet.add("Sábado");
        miSet.add("Domingo");
        //imprimir(miSet);
        
        Map<String,String> miMap = new HashMap<>();
        miMap.put("valor1", "Jesús");
        miMap.put("valor2", "Silvia");
        miMap.put("valor3", "Eva");
        
        String elementoMap= miMap.get("valor2");
        System.out.println("elemento = " + elementoMap);
        
        imprimir(miMap.keySet()); //regresa el set de llaves y lo podemos recorrer
        imprimir(miMap.values()); //regresa los valores
    }

    public static void imprimir(Collection<String> coleccion) {
//        for (var item : coleccion) {
//            System.out.println("item = " + item);
//        }
        coleccion.forEach(item -> {
            System.out.println("item = " + item);
        });
    }
}
