
package mx.com.pegachucho.ventas.test;

import mx.com.pegachucho.ventas.*;


public class VentasTest {
    public static void main(String[] args) {
        Producto producto = new Producto(50.00, "Camisa");
        Producto producto2 = new Producto(100.00, "Pantalón");
        Producto producto3 = new Producto(350.00, "Sudadera");
        Producto producto4 = new Producto(1500.00, "Vestido");
        
        Orden orden1 = new Orden();
        orden1.agregarProducto(producto);
        orden1.agregarProducto(producto2);
        orden1.mostarOrden();
        
        Orden orden2 = new Orden();
        orden2.agregarProducto(producto);
        orden2.agregarProducto(producto3);
        orden2.agregarProducto(producto4);
        orden2.mostarOrden();
    }
}
