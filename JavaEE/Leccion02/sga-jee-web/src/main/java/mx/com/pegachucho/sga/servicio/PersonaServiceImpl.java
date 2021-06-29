package mx.com.pegachucho.sga.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import mx.com.pegachucho.sga.datos.iPersonaDAO;
import mx.com.pegachucho.sga.domain.Persona;

@Stateless
public class PersonaServiceImpl implements iPersonaServiceRemote, iPersonaService {
    
    @Inject
    private iPersonaDAO personaDao;

    @Override
    public List<Persona> listarPersonas() {
        return personaDao.findAllPersonas();
    }

    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
        return personaDao.findPersonaById(persona);
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona persona) {
        return personaDao.findPersonaByEmail(persona);
    }

    @Override
    public void registrarPersona(Persona persona) {
        personaDao.insertPersona(persona);
    }

    @Override
    public void modificarPersona(Persona persona) {
        personaDao.updatePersona(persona);
    }

    @Override
    public void eliminarPersona(Persona persona) {
        personaDao.deletePersona(persona);
    }

}