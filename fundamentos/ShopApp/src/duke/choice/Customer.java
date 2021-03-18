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
public class Customer {

    public Customer(String name, int measurement) {
        this.name = name;
        setSize(measurement);
    }

    private String name;
    private String size;
    private Clothing[] items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setSize(int measurement) {
        switch (measurement) {
            case 1,2,3:
                this.setSize("S");
                break;
            case 4,5,6:
                this.setSize("M");
                break;
            case 7,8,9:
                this.setSize("L");
                break;
            default:
                this.setSize("XL");
                break;
        };
    }

    public void addItems(Clothing[] items) {
        this.items = items;
    }

    public Clothing[] getItems() {
        return items;
    }

    public double getTotalClothingCost() {
        double total = 0.0;
        for (Clothing item : items) { //items es del tipo "Clothing" y por eso debe oincidir
            //if (c1.getSize().equals(item.getSize())) {
            total = total + item.getPrice();
            //System.out.println(item.getDescription() + ", " + item.getPrice() + ", " + item.getSize());
            //if (total > 15.0) {
            //break;
            //}
            //}
        }
        return total;
    }
}
