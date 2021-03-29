package test;

public class TestArgumentosVariables {

    public static void main(String[] args) {
        imprimirNumeros(3, 454, 545, 3, 2, 1);
        imprimirNumeros(142, 1124, 1);

        variosParametros("Silvita", 234, 342, 33243, 212, 4, 4);

    }

    private static void variosParametros(String nombre, double... numeros) {
        System.out.println("nombre = " + nombre);
        imprimirNumeros(numeros);
    }

    private static void imprimirNumeros(double... numeros) {
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("elemento: " + numeros[i]);
        }
    }
}
