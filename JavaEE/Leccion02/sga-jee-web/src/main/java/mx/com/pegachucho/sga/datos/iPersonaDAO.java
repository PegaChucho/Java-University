package mx.com.pegachucho.sga.datos;

import java.util.List;
import mx.com.pegachucho.sga.domain.Persona;

public interface iPersonaDAO {
    public List<Persona> findAllPersonas();
    
    public Persona findPersonaById(Persona persona);
    
    public Persona findPersonaByEmail(Persona persona);
    
    public void insertPersona(Persona persona);
    
    public void updatePersona(Persona persona);
    
    public void deletePersona(Persona persona);
    
}
