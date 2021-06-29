package mx.com.pegachucho.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import mx.com.pegachucho.dao.iPersonaDAO;
import mx.com.pegachucho.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Esto es un Servlet!
@Controller
@Slf4j
public class ConroladorInicio {
    
    @Autowired //Es similar a la notación de inject
    private iPersonaDAO personaDao;
    
    @GetMapping("/") //http://localhost:8080/
    //Principio de Hollywood: "No me llames, yo te voy a llamar B)"
    public String inicio(Model model){
        
        List<Persona> personas = (List<Persona>) personaDao.findAll();
        
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("personas", personas);
        
        return "index";
        
    }
}
