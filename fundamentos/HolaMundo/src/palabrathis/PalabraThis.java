package palabrathis;

public class PalabraThis {

    public static void main(String[] args) {
        Persona persona1 = new Persona("Jesús", "Pérez");
        System.out.println("persona1 = " + persona1.nombre + " " + persona1.apellido);

    }
}

class Persona {

    String nombre;
    String apellido;

    Persona(String nombre, String apellido) {
        //super(); //llama al constructor de la clase padre
        this.nombre = nombre;
        this.apellido = apellido;
        System.out.println("objeto persona usando this= " + this);
        new Imprimir().imprimir(this);
        /*de esta manera ya se crea un onjeto de la clase
        imprimir directamente sin necesidad de asignarle ese objeto a una variable, 
        oir ejemplo "Imprimir imprimir = new Imprimir();" */
        //Imprimir imprimir1= new Imprimir();
        //imprimir1.imprimir(this)
    }
}

class Imprimir {

    public void imprimir(Persona persona) {
        System.out.println("Persona desde imprimir: " + persona);
        System.out.println("Impresión del objeto actual(this): " + this);
    }
}
