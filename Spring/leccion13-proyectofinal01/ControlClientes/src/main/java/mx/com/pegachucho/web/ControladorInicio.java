package mx.com.pegachucho.web;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.pegachucho.domain.Persona;
import mx.com.pegachucho.servicio.iPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//Esto es un Servlet!
@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired //Es similar a la notación de inject
    private iPersonaService ps;
    
    @GetMapping("/") //http://localhost:8080/  tipo GET
    //Principio de Hollywood: "No me llames, yo te voy a llamar B)"
    public String inicio(Model model, @AuthenticationPrincipal User user) {//para recuperar el usuario que se inició sesión
        
        List<Persona> personas = (List<Persona>) ps.listarPersonas();
        
        log.info("Ejecutando el controlador Spring MVC");
        log.info("Usuario" + user);
        model.addAttribute("personas", personas);//en lugar de request.setAttribute
        
        double saldoTotal =0;
        for (Persona p : personas) {
            saldoTotal += p.getSaldo();
        }
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", personas.size());//comparte el numero total de clientes
        
        return "index"; //el nombre d ela pagina a donde redirige este controlador
        
    }
    
    @GetMapping("/agregar")
    public String agregar(Persona persona) { //inyectamos un objeto de tipo persona
        return "modificar";//el nombre de la pagina a donde redirige este controlador
    }
    
    @PostMapping("/guardar")
    public String guardar(@Valid Persona persona, Errors e) { //inyectamos un objeto de tipo persona
        if (e.hasErrors()) {
            return "modificar";
        }
        ps.guardar(persona);
        return "redirect:/"; //return "index";//el nombre de la pagina a donde redirige este controlador
    }
    
    @GetMapping("/editar/{idPersona}") //path variable
    public String editar(Persona persona, Model model) { //Si ya existe lo va recuperar y no es necesario hacer setIdPersona
        persona = ps.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar"; //return "modificar";//el nombre de la pagina a donde redirige este controlador
    }
    
    @GetMapping("/eliminar") //query param
    public String eliminar(Persona persona, Model model) { //Si ya existe lo va recuperar y no es necesario hacer setIdPersona
        ps.eliminar(persona);
        model.addAttribute("persona", persona);
        return "redirect:/"; //return "index";//el nombre de la pagina a donde redirige este controlador
    }
    
}
