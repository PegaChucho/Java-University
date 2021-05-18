package test;

import datos.*;
import domain.*;
import java.sql.*;
import java.util.*;


public class TestManejoPersonas {

    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            
            IPersonaDAO personaDao = new PersonaDAO(conexion);
            
            List<PersonaDTO> personas = personaDao.listar();
            imprimir(personas);
            
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

    public static void imprimir(List<PersonaDTO> personas) {
        personas.forEach(persona -> {
            System.out.println("persona = " + persona);
        });
    }
}
