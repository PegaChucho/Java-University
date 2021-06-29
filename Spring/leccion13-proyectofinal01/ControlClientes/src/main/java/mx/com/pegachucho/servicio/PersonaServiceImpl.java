package mx.com.pegachucho.servicio;

import java.util.List;
import mx.com.pegachucho.dao.iPersonaDAO;
import mx.com.pegachucho.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //Esta notación sirve para poder despues inyectar esta clase en el controlador
public class PersonaServiceImpl implements iPersonaService {

    @Autowired
    private iPersonaDAO personaDao;

    @Override
    @Transactional(readOnly = true) //No necesita crear transacción porque es de solo lectura
    public List<Persona> listarPersonas() {
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Transactional
    @Override
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return personaDao.findById(persona.getIdPersona()).orElse(null); //regresa una persona encontrada o null 
    }

}
