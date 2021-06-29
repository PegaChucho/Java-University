package mx.com.pegachucho.sga.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.com.pegachucho.sga.domain.Persona;

@Local
public interface iPersonaService {
    public List<Persona> listarPersonas();

    public Persona encontrarPersonaPorId(Persona persona);

    public Persona encontrarPersonaPorEmail(Persona persona);

    public void registrarPersona(Persona persona);

    public void modificarPersona(Persona persona);

    public void eliminarPersona(Persona persona);
}