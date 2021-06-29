package mx.com.pegachucho.web;

import java.util.Locale;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver; //il8n = internacionalization

@Configuration
public class WebConfig implements WebMvcConfigurer{
    
    
    //para agregar los idiomas a nuestra página
    
    //se define el lenguaje por default
    @Bean //va a agregar el bean al contexto de spring
    public LocaleResolver localeResolver(){
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("es"));
        return slr;
    }
    
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang"); 
        return lci;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry reg){
        reg.addInterceptor(localeChangeInterceptor());
    }
    
    //para mapear paths que no tienen que pasar por el controlador
    @Override
    public void addViewControllers(ViewControllerRegistry reg){//para mapear paths que no tienen que pasar por el controlador
        reg.addViewController("/").setViewName("index"); //porque este path ya está restringido
        reg.addViewController("/login").setViewName("/login"); //para que en caso de no haber hehco login spring nos mande a la pagina de login
        reg.addViewController("/errores/403").setViewName("/errores/403"); //tampoco pasa por ningun controlador
    }
}
