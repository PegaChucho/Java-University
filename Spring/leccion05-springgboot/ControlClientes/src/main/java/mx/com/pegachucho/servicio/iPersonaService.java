package mx.com.pegachucho.servicio;

import java.util.List;
import mx.com.pegachucho.domain.Persona;

public interface iPersonaService {
    
    public List<Persona> listarPersonas();
    
    public void guardar (Persona persona);
    
    public void eliminar(Persona persona);
    
    public Persona encontrarPersona (Persona persona);
}
