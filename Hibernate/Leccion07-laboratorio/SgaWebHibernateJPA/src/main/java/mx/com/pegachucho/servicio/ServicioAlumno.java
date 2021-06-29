package mx.com.pegachucho.servicio;

import java.util.List;
import mx.com.pegachucho.dao.AlumnoDAO;
import mx.com.pegachucho.domain.Alumno;

public class ServicioAlumno {
    
    private AlumnoDAO alumnoDao= new AlumnoDAO();
    
    public List<Alumno> listarAlumno(){
        return alumnoDao.listar();
    }
    
    public void guardarAlumno (Alumno a){
        if (a != null && a.getIdAlumno() == null) { //no se ha guardado
            alumnoDao.insertar(a);
        }else{
            alumnoDao.modificar(a);
        }
    }
    
    public void eliminarAlumno (Alumno a){
        alumnoDao.eliminar(a);
    }
    
    public Alumno encontrarAlumno(Alumno a){
        return alumnoDao.buscarPorID(a);
    }
    
}
