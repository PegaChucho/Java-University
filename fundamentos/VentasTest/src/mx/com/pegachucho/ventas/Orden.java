package mx.com.pegachucho.ventas;

public class Orden {

    private final static int MAX_PRODUCTOS = 10;
    private static int contadorOrdenes;
    private final int idOrder;
    private Producto productos[];
    private int contadorProductos;

    public Orden() {
        this.idOrder = ++contadorOrdenes;
        this.productos = new Producto[Orden.MAX_PRODUCTOS];//inicializar el arreglo
    }

    public void agregarProducto(Producto producto) {
        if (this.contadorProductos < Orden.MAX_PRODUCTOS) {
            this.productos[this.contadorProductos++] = producto;
        } else {
            System.out.println("Se ha superado el máximo de productos: " + Orden.MAX_PRODUCTOS);
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < this.contadorProductos; i++) {
            Producto producto = this.productos[i];
            total += producto.getPrecio();
        }
        return total;
    }

    public void mostarOrden() {
        System.out.println("Id Orden: " + this.idOrder);
        double totalOrden = this.calcularTotal();
        System.out.println("Total= $" + totalOrden);

        if (this.contadorProductos > 0) {
            System.out.println("productos de la orden:");
            for (int i = 0; i < this.contadorProductos; i++) {
                System.out.println(this.productos[i]);
            }
        }else{
            System.out.println("No hay productos agregados");
        }
//        for (var item: productos){
//            System.out.println("item = " + item);
//        }

    }

}
