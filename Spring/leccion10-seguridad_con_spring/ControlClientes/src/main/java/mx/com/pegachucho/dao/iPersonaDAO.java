package mx.com.pegachucho.dao;

import mx.com.pegachucho.domain.Persona;
import org.springframework.data.repository.CrudRepository;

/*
Al extender de crud repository ya no tenemos que crear los metodos clasicos de 
CRUD, tampoco tenemos que crear una implementación de esta interface.
Tambien le podemos agregar métodos personalizados
*/
public interface iPersonaDAO extends CrudRepository<Persona, Long>{ //Clase, tipo del ID primary key
    
    
}
