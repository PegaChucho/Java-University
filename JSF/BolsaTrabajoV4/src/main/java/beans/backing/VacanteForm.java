package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Named(value = "vacanteForm")
@RequestScoped
public class VacanteForm {
    
    @Inject
    private Candidato candidato;
    Logger log = LogManager.getRootLogger();
    
    public VacanteForm(){
        log.info("Creando el objeto VacanteForm");
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    public String enviar(){
        if (this.candidato.getNombre().equals("Jesus")) {
            if (this.candidato.getApellido().equals("Perez")) {
                String msg="Gracias, pero Jesus Perez ya trabaja aquí.";
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg, msg);
                FacesContext facescontext= FacesContext.getCurrentInstance();
                String componentID = null; //mensaje global
                facescontext.addMessage(componentID, facesMessage);
                return "index";
            }
            log.info("Entrando al caso de éxito");
            return "exito.xhtml";
        }else{
            log.info("Entrando al caso de fallo");
            return "fallo.xhtml";
        }
    }
    
}
