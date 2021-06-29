package mx.com.pegachucho.servicio;

import java.util.List;
import mx.com.pegachucho.dao.PersonaDAO;
import mx.com.pegachucho.domain.Persona;

public class ServicioPersonas {
    
    public ServicioPersonas() {
        this.personaDAO = new PersonaDAO();
    }
    
    private PersonaDAO personaDAO;

    public List<Persona> listarPersonas(){
        return personaDAO.listar();
    }
}
