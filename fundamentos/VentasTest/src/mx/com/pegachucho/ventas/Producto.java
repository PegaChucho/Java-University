package mx.com.pegachucho.ventas;

public class Producto {

    private static int contadorProductos;
    private final int idProducto;
    private double precio;
    private String nombre;

    public Producto(){
        this.idProducto= ++contadorProductos;
    }

    public Producto(double precio, String nombre) {
        this();
        this.precio = precio;
        this.nombre = nombre;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{idProducto=").append(idProducto);
        sb.append(", precio=").append(precio);
        sb.append(", nombre=").append(nombre);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
