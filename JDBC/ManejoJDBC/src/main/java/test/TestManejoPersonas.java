package test;

import datos.*;
import domain.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestManejoPersonas {

    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            
            PersonaDAO personaDao = new PersonaDAO(conexion);
            
            Persona personaAct= new Persona(2, "Silvia Fernanda", "Orozco", "silvita@gmail.com", "5538780254");
            personaDao.actualizar(personaAct);
            
            var personaNueva= new  Persona("Lucero", "Pérez", "lucerondiga@hotmail.com", "53917682");
            personaDao.insertar(personaNueva);
            
            conexion.commit();
            System.out.println("Se ha hecho commit de la transacción");
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
        
        
        
        
        
    }

    public static void imprimir(List<Persona> personas) {
        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
    }
}
