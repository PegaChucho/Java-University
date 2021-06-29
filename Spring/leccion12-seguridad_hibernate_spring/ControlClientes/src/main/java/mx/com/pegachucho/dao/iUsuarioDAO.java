package mx.com.pegachucho.dao;

import mx.com.pegachucho.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface iUsuarioDAO extends JpaRepository<Usuario, Long> {

    Usuario findByUsername(String username); //debe tener este nombre!

}
