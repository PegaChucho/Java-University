package mx.com.pegachucho.sga.domain;

import java.io.Serializable;


public class Persona implements Serializable{
    private static final long serialVersionUID=1L;
    private int idpersona;
    private String nombre;
    private String apellido;
    private String email;
    private String teléfono;
    
    public Persona(){};

    public Persona(int idpersona, String nombre, String apellido, String email, String teléfono) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.teléfono = teléfono;
    }
    

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeléfono() {
        return teléfono;
    }

    public void setTeléfono(String teléfono) {
        this.teléfono = teléfono;
    }

    @Override
    public String toString() {
        return "Persona{" + "idpersona=" + idpersona + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", tel\u00e9fono=" + teléfono + '}';
    }
    
    
}
