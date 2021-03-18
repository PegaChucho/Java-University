/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author jperezgarcia
 */
public class Caja {

    double ancho, alto, profundo;

    public Caja() {

    }

    public Caja(double ancho, double alto, double profundo) {
        this.ancho = ancho;
        this.alto = alto;
        this.profundo = profundo;
    }
    
    public double volumenCaja(){
        return this.alto*this.ancho*this.profundo;
    }

}
