
package mx.com.pegachucho.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncriptarPassword { //Clase para encriptar y desencriptar contraseñas
    public static void main(String[] args) {
        
        String password= "123";
        System.out.println("password = " + password);
        System.out.println("password encriptado= " + encriptarPassword(password));
    }
    
    public static String encriptarPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
