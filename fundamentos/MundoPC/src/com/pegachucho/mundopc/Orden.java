package com.pegachucho.mundopc;

public class Orden {
    
    private final static int MAX_COMPUTADORAS = 10;
    private static int contadorOrdenes;
    private final int idOrden;
    private Computadora computadoras[];
    private int contadorComputadoras;

    public Orden() {
        this.idOrden = ++contadorOrdenes;
        this.computadoras = new Computadora[Orden.MAX_COMPUTADORAS];//inicializar el arreglo
    }

    public void agregarComputadora(Computadora computadora) {
        if (this.contadorComputadoras < Orden.MAX_COMPUTADORAS) {
            this.computadoras[this.contadorComputadoras++] = computadora;
        } else {
            System.out.println("Se ha superado el máximo de productos: " + Orden.MAX_COMPUTADORAS);
        }
    }

    public void mostarOrden() {
        System.out.println("Id Orden: " + this.idOrden);
        if (this.contadorComputadoras > 0) {
            System.out.println("productos de la orden:");
            for (int i = 0; i < this.contadorComputadoras; i++) {
                System.out.println(this.computadoras[i]);
            }
        }else{
            System.out.println("No hay computadoras agregadas");
        }

    }

}

