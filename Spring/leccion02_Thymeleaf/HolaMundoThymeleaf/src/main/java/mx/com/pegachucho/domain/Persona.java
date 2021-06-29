package mx.com.pegachucho.domain;

import lombok.Data;

@Data //agrega el contructor vacio, getters y setters, hashcode y to string
public class Persona {
    
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
}
