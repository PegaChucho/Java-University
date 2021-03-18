
import java.util.Scanner;

public class HolaMundo {

    public static void main(String args[]) {

        inicio://goto
        for (var contador = 0; contador <= 20; contador++) {
            if (contador % 2 != 0) {
                continue inicio;//va a la siguiente iteración, goto
            }
            System.out.println("contador = " + contador);
        }//la variable contador se destruye al salir del ciclo for

    }
}
