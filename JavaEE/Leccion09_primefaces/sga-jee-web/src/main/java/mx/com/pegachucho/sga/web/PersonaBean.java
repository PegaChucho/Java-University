package mx.com.pegachucho.sga.web;

import java.util.*;
import javax.annotation.PostConstruct;
import javax.inject.*;
import javax.enterprise.context.*;
import mx.com.pegachucho.sga.domain.Persona;
import mx.com.pegachucho.sga.servicio.PersonaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.RowEditEvent;

@Named(value = "personaBean")
@RequestScoped
public class PersonaBean {

    Logger log = LogManager.getRootLogger();

    //inyectamos el personaService
    @Inject
    private PersonaService personaService;

    private Persona personaSeleccionada;

    List<Persona> personas;

    public PersonaBean() {
        log.debug("Iniciando el objeto personaBean");
    }

    //Ejeucion del codigo despues de la creación del bean
    @PostConstruct
    public void inicializar() {
        //iniciamos las variables
        this.personas = personaService.listarPersonas();
        log.debug("Personas recuperadas en Managebeans" + this.personas);
        this.personaSeleccionada = new Persona();
    }

    ;
    
    //método declarado en el JSF de listarPersonas
    public void editListener(RowEditEvent event) {
        Persona persona = (Persona) event.getObject();
        personaService.modificarPersona(persona);
    }

    public Persona getPersonaSeleccionada() {
        return personaSeleccionada;
    }

    public void setPersonaSeleccionada(Persona personaSeleccionada) {
        this.personaSeleccionada = personaSeleccionada;
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public void agregarPersona() {
        this.personaService.registrarPersona(personaSeleccionada);
        this.personas.add(personaSeleccionada);
        this.personaSeleccionada = null;
    }

    public void eliminarPersona() {
        this.personaService.eliminarPersona(personaSeleccionada);
        this.personas.remove(this.personaSeleccionada);
        this.personaSeleccionada = null;

    }
    
    public void reiniciarPersonaSeleccionada(){
        this.personaSeleccionada = new Persona();
    }

}
