package mx.com.pegachucho.peliculas.servicio;

public interface ICatalogoPeliculas {

    String NOMBRE_RECURSO = "peliculas.txt"; // si no ponemos el psf no pasa nada

    void agregarPelicula(String nombrePelicula);

    void listarPeliculas();

    void buscarPelicula(String buscar);

    void iniciarCatalogoPeliculas();

}
