package mx.com.pegachucho.test;

import java.util.List;
import mx.com.pegachucho.dao.*;



public class TestDAOs {
    public static void main(String[] args) {
        System.out.println("Alumnos: ");
        AlumnoDAO alumnoDao= new AlumnoDAO();
        imprimir(alumnoDao.listar());
        
        System.out.println("Domicilios: ");
        DomicilioDAO domicilioDao = new DomicilioDAO();
        imprimir(domicilioDao.listar());
        
        System.out.println("Contactos: ");
        ContactoDAO contactoDao = new ContactoDAO();
        imprimir(contactoDao.listar());
        
        System.out.println("Cursos: ");
        CursoDAO cursoDao = new CursoDAO();
        imprimir(cursoDao.listar());
        
        System.out.println("Asignaciones: ");
        AsignacionDAO asignacionDao = new AsignacionDAO();
        imprimir(asignacionDao.listar());
    }
    
    private static void imprimir(List coleccion){//lista de objetos sin ningun tipo (object)
        for (Object o : coleccion) {
            System.out.println("Valor: " + o);
        }
    }
}
