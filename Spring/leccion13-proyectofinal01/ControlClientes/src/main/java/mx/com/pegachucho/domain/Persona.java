package mx.com.pegachucho.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data //agrega el contructor vacio, getters y setters, hashcode y to string
@Entity
@Table(name = "persona")
public class Persona implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;

    @NotEmpty //not null solo valida que no esté vacio, esta anotacion sirve tambien para cadenas
    private String nombre;

    @NotEmpty
    private String apellido;

    @NotEmpty
    @Email
    @Column(name = "mail")
    private String email;

    private String telefono;
    
    @NotNull //solo valida que un campo no esté vacio
    private double saldo;

}
