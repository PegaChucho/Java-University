package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
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

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }
    
    public String enviar(){
        if (this.candidato.getNombre().equals("Jesus")) {
            log.info("Entrando al caso de éxito");
            return "exito.xhtml";
        }else{
            log.info("Entrando al caso de fallo");
            return "fallo.xhtml";
        }
    }
    
}
