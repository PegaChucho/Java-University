
package test;


public class TestArreglos {
    public static void main(String[] args) {
        int edades[]=new int[3];
        System.out.println("edades = " + edades);
        
        edades[0]= 10;
        edades[1]= 5;
        edades[2]= 8;
        
        for (int item: edades){
            System.out.println("item = " + item);
        }
        
        for (int i=0; i< edades.length; i++){
            System.out.println("edades elemento " + i +" : "+edades[i]);
        }
        
        
    }
}
