package mx.com.pegachucho.servicio;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import mx.com.pegachucho.dao.iUsuarioDAO;
import mx.com.pegachucho.domain.Rol;
import mx.com.pegachucho.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService") //para spring esta clase se va a llamar asi
@Slf4j
public class UsuarioService implements UserDetailsService{
    
    @Autowired //inyecta un objeto usuarioDao
    private iUsuarioDAO usuarioDao;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario= usuarioDao.findByUsername(username);
        
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        
        ArrayList roles= new ArrayList<GrantedAuthority>(); //se envuelven los roles en esta clase GrantedAuthority
        for (Rol rol : usuario.getRoles()) {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
    
}
