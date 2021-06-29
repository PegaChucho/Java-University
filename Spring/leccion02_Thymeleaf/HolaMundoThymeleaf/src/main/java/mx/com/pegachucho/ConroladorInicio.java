package mx.com.pegachucho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import mx.com.pegachucho.domain.Persona;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Esto es un Servlet!
@Controller
@Slf4j
public class ConroladorInicio {
    
    @Value("${index.saludo}")//El valor se recupera del application.propierties
    private String saludo;
    
    @GetMapping("/") //http://localhost:8080/
    //Principio de Hollywood: "No me llames, yo te voy a llamar B)"
    public String inicio(Model model){
        
        String msj= "Hola Mundo con Thymeleaf";
        Persona persona = new Persona();
        persona.setNombre("Jesús");
        persona.setApellido("Pérez");
        persona.setEmail("jesus_perez_0123@gmail.com");
        persona.setTelefono("5538780254");
        
        Persona persona2 = new Persona();
        persona2.setNombre("Silvia");
        persona2.setApellido("Orozco");
        persona2.setEmail("silvita@gmail.com");
        persona2.setTelefono("5592384795");
        
//        List<Persona> personas = new ArrayList<>();
//        personas.add(persona);
//        personas.add(persona2);

       var personas = Arrays.asList(persona, persona2);
       //var personas = new ArrayList<>();
        
        
        
        log.info("Ejecutando el controlador Spring MVC");
        model.addAttribute("msj", msj);
        model.addAttribute("saludo", saludo);
        //model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);
        
        return "index";
        
    }
}
