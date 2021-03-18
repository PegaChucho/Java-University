/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duke.choice;

/**
 *
 * @author jperezgarcia
 */
public class Clothing implements Comparable<Clothing>{

    public Clothing(String description, double price, String size) {
        this.description = description;
        this.price = setPrice(price);
        this.size = size;
    }
    private String description;
    private double price;
    private String size = "M"; //si una propiedad ya tiene un valor asignado NetBeans la omitirá para los constuctores

    //private final double MIN_PRICE =10.0; //final las hace constantes pero no accesibles para las demas clases
    //private final double MIN_TAX =0.2;
    public final static double MIN_PRICE = 10.0;
    public final static double MIN_TAX = 0.2;

    /*
    Hacer esto del final static permite llamar a min price y al tax desde la
    clase, por ejemplo Clothing.MIN_PRICE y no tener que instanciar un objeto y 
    luego pedirle la propiedad, como c1.MIN_PRICE
     */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price = price;
    }

    public double setPrice(double price) {
        this.price = (price > MIN_PRICE) ? price : MIN_PRICE;
        return this.price * (1 + MIN_TAX);
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return getDescription() + ", " + getPrice() + ", " + getSize();
    }
    
    @Override
    public int compareTo (Clothing c){
        return this.description.compareTo(c.description);
    }
}
