package mx.com.pegachucho.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{ //para agregar usuarios, contraseñas y roles (autenticación)
        auth.inMemoryAuthentication()
                .withUser("admin")
                    .password("{noop}123") //{noop} indica que el password no requiere estar codificado
                    .roles("ADMIN","USER") //le agrega los roles ROLE_ADMIN de manera automática
                .and()
                .withUser("user")
                    .password("{noop}123")
                    .roles("USER")
                ;
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
                .loginPage("/login") //pagina de login personalizada
            .and()
                .exceptionHandling().accessDeniedPage("/errores/403") //página de errores personalizada
            ;
    }
}
