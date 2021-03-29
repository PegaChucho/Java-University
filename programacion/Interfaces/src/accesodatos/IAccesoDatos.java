
package accesodatos;

public interface IAccesoDatos {
    int MAX_REGISTRO=10;
    
    public void insertar();
    public void listar();
    public void actualizar();
    public void eliminar();
}
