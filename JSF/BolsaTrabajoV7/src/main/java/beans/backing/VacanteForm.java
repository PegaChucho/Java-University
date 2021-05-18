package beans.backing;

import beans.model.Candidato;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.*;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Named(value = "vacanteForm")
@RequestScoped
public class VacanteForm {
    
    @Inject
    private Candidato candidato;
    
    private boolean comentarioEnviado = true;
    
    Logger log = LogManager.getRootLogger();
    public VacanteForm(){
        log.info("Creando el objeto VacanteForm");
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public boolean isComentarioEnviado() {
        return comentarioEnviado;
    }

    public void setComentarioEnviado(boolean comentarioEnviado) {
        this.comentarioEnviado = comentarioEnviado;
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
    
    public void codigoPostalListener(ValueChangeEvent valueChangeEvent){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UIViewRoot uiViewRoot=facesContext.getViewRoot();
        String nuevoCodigoPostal=(String) valueChangeEvent.getNewValue();
        
        if ("07230".equals(nuevoCodigoPostal)) {
            
            UIInput coloniaIdInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:coloniaId");
            int coloniaId= 1;
            coloniaIdInputText.setValue(coloniaId);
            coloniaIdInputText.setSubmittedValue(coloniaId);
            
            UIInput ciudadInputText = (UIInput) uiViewRoot.findComponent("vacanteForm:ciudad");
            String nuevaCiudad="CDMX";
            ciudadInputText.setValue(nuevaCiudad);
            ciudadInputText.setSubmittedValue(nuevaCiudad);
            
            facesContext.renderResponse();
        }
    }
    
    public void ocultarComentario(ActionEvent actionEvent){
        this.comentarioEnviado= !this.comentarioEnviado;
    }
    
}
