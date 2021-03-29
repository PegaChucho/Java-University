package mx.com.pegachucho.peliculas.servicio;

import mx.com.pegachucho.peliculas.datos.AccesoDatos;
import mx.com.pegachucho.peliculas.datos.IAccesoDatos;
import mx.com.pegachucho.peliculas.domain.Pelicula;
import mx.com.pegachucho.peliculas.excepciones.AccesoDatosEx;
import mx.com.pegachucho.peliculas.excepciones.LecturaDatosEx;

public class CatalogoPeliculas implements ICatalogoPeliculas {

    private final IAccesoDatos datos;


    public CatalogoPeliculas() {
        this.datos = new AccesoDatos();
    }

    @Override
    public void agregarPelicula(String nombrePelicula) {
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx ex) {
            ex.printStackTrace();
            System.out.println("Error aceso a datos");
        }

    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for (var pelicula : peliculas) {
                System.out.println("pelicula = " + pelicula);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);

        }
    }

    @Override
    public void buscarPelicula(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
            if (resultado != null){
            System.out.println("resultado = " + resultado);
            } else{
                System.out.println("No se encontró la pelicula "+"'"+buscar+"'");
            }
        } catch (LecturaDatosEx ex) {
            System.out.println("Error de acceso a datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if (this.datos.existe(NOMBRE_RECURSO)) {
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            } else {
                this.datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx ex) {
            System.out.println("Error al iniciar catálogo");
            ex.printStackTrace(System.out);
        }
    }

}
