package mx.com.pegachucho.sga.domain;

import java.io.Serializable;
import javax.persistence.*;

//Convertimos esta clase en una entidad de base de datos
@Entity
@NamedQueries({
    //Recuperamos objetos completos de la BBDD
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p ORDER BY p.idPersona")
})
@Table(name = "persona")
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;

    //Especificamos que es el id y usamos el segundo tag porque es autoincrementable
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Como idPersona no es lo mismo que id_perona de la base de datos:
    @Column(name = "id_persona")
    private int idPersona;

    private String nombre;
    private String apellido;
    @Column(name = "mail")
    private String email;
    private String telefono;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String email, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }

    public int getIdPersona() {
        return idPersona;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono + '}';
    }

}
