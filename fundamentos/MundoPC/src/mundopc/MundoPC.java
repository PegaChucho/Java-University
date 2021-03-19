
package mundopc;

import com.pegachucho.mundopc.*;

public class MundoPC {
    public static void main(String[] args) {
        
        Teclado teclado1 = new Teclado("usb", "Balam Rush");
        Raton raton1 = new Raton("usb", "Game Factor");
        Monitor monitor1= new Monitor("Game Factor", 27);
        
        Computadora computadora1 = new Computadora("Cooler Master",
                monitor1, teclado1, raton1);
        
        Orden orden1= new Orden();
        orden1.agregarComputadora(computadora1);
        orden1.mostarOrden();
        
        
    }
}
