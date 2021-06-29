package mx.com.pegachucho.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Bean //con esto el objeto va a estar disponible dentro del contenedor de spring
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception{ //este objeto se agrega de manera automatica 
        build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    
    @Override 
    protected void configure(HttpSecurity http) throws Exception{ //restricción de URLs (autorización)
        http.authorizeRequests()
            .antMatchers("/editar/**", "/agregar/**", "/eliminar")//con esto restringiremos todos los paths dentro de editar
                .hasRole("ADMIN")
            .antMatchers("/")
                .hasAnyRole("USER", "ADMIN")
            .and()
                .formLogin()
                .loginPage("/login")
            .and()
                .exceptionHandling().accessDeniedPage("/errores/403")
            ;
    }
}
