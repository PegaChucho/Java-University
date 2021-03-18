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
public class ShopApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        double total = 0.0;
        System.out.println("Welcome to Duke Choice Shop!, the tax is: " + Clothing.MIN_TAX);

        Customer c1 = new Customer("Pinky", 3);

        //cambiar lo siguiente en un ciclo for
        Clothing item1 = new Clothing("Blue Jacket", 20.9, "M");
        Clothing item2 = new Clothing("Orange T-Shirt", 10.5, "S");

        Clothing[] items = {item1, item2,
            new Clothing("Green Scarf", 5.0, "S"),
            new Clothing("Blue T-Shirt", 10.5, "S")};

        //item1.setDescription("Blue Jacket");
        //item1.setPrice(20.9);
        //item1.setSize("M");
        c1.addItems(items);

        //System.out.println(item1.description + ", " + item1.price + ", " + item1.size);
        //System.out.println(item2.description + ", " + item2.price + ", " + item2.size);
        //total = (item1.price + 2 * item2.price) * 1 + tax;
        //int measurement = 6;
        //c1.setSize(measurement);
        System.out.println("Customer is: " + c1.getName() + ", the size is: " + c1.getSize());

        for (Clothing item : c1.getItems()) { //items es del tipo "Clothing" y por eso debe oincidir
            //System.out.println("items:" + item.getDescription()+
                   //", price: " + item.getPrice()+ 
                   // ", size: " + item.getSize());
                   System.out.println("item:" + item);
                   
        }

        System.out.println("total = " + c1.getTotalClothingCost());

        double average = 0.0;
        int count = 0;

        for (Clothing item : c1.getItems()) {
            if (item.getSize() == "L") {
                average += item.getPrice();
                count++;
            }
        }
        try {
            average = (count<=0)? 0: average / count;
            System.out.println("average = " + average);
        } catch (ArithmeticException e){
            System.out.println("División entre 0, paps");
        }

    }

}
