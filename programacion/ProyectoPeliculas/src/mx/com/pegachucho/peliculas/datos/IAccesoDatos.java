package mx.com.pegachucho.peliculas.datos;

import java.util.*;
import mx.com.pegachucho.peliculas.domain.Pelicula;
import mx.com.pegachucho.peliculas.excepciones.*;

public interface IAccesoDatos {

    boolean existe(String nombreRecurso) throws AccesoDatosEx;

    List<Pelicula> listar(String nombreRecurso) throws AccesoDatosEx;

    void escribir(Pelicula pelicula, String nombreRecurso,
            boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;

    void crear(String nombreRecurso) throws AccesoDatosEx;

    void borrar(String nombreRecurso) throws AccesoDatosEx;

}
