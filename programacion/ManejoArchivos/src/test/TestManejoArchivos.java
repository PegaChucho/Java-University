package test;

import java.io.*;
import java.util.*;
import static manejoarchivos.ManejoArchivos.*;


public class TestManejoArchivos {

    public static void main(String[] args) {
        var nombreArchivo = "Prueba.txt";
        //crearArchivo(nombreArchivo);
        
//        escribirArchivo(nombreArchivo, boncheTexto(1));
//        anexarArchivo(nombreArchivo, boncheTexto(1));

        leerArchivo(nombreArchivo);
    }

   
}
