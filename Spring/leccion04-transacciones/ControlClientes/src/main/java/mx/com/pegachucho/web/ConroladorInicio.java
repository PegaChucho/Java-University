package mx.com.pegachucho.web;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com.pegachucho.domain.Persona;
import mx.com.pegachucho.servicio.iPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Esto es un Servlet!
@Controller
@Slf4j
public class ConroladorInicio {
    
    @Autowired //Es similar a la notación de inject
    private iPersonaService ps;
    
    @GetMapping("/") //http://localhost:8080/
    //Principio de Hollywood: "No me llames, yo te voy a llamar B)"
    public String inicio(Model model){
        
        List<Persona> personas = (List<Persona>) ps.listarPersonas();
        
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("personas", personas);
        
        return "index";
        
    }
}
