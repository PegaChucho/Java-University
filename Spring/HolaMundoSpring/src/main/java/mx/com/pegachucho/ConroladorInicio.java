package mx.com.pegachucho;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ConroladorInicio {
    
    @GetMapping("/") //http://localhost:8080/
    public String inicio(){
        
        log.info("Ejecutando el controlador REST");
        log.debug("Más detalle del controlador");
        return "Hola Mundo con Spring :D";
    }
}
