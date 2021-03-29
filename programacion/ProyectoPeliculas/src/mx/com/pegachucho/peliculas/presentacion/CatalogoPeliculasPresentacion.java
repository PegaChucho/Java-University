package mx.com.pegachucho.peliculas.presentacion;

import java.util.*;
import mx.com.pegachucho.peliculas.servicio.*;

public class CatalogoPeliculasPresentacion {

    public static void main(String[] args) {
        var opcion = -1;
        var scanner = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculas();

        while (opcion != 0) {
            System.out.println("Elige una opción: \n"
                    + "1.- Iniciar catálogo de películas\n"
                    + "2.- Agregar pelicula\n"
                    + "3.- Listar peliculas\n"
                    + "4.- Buscar pelicula\n"
                    + "0.- Salir");
            opcion = Integer.parseInt(scanner.nextLine()); //se convierte el string a tipo integer
            switch (opcion) {
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Por favor indique el nombre de su pelicula: ");
                    var nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Introduce el nombre de la elicula que quieres buscar: ");
                    String buscar = scanner.nextLine();
                    catalogo.buscarPelicula(buscar);
                    break;
                case 0:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("I4ntente otra vez");
                    break;
            }
        }
    }
}
