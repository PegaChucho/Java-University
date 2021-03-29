package domain;

public class Persona {

    private final int idPersona;
    private static int contadorPersonas;

    static {//bloque de codigo de inicialización estático, se ejecuta antes del constructor
        System.out.println("Ejecucion de bloque estático");
        ++Persona.contadorPersonas;
        //idPersona=10 // no se puede ya que no es una variable estática
    }

    { //bloque de inicialización no estático
        System.out.println("Ejecución de bloque no estático");
        this.idPersona = Persona.contadorPersonas;
    }

    public Persona(){
        System.out.println("Ejecución del constructor");
    }

    public int getIdPersona() {
        return this.idPersona;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{idPersona=").append(idPersona);
        sb.append('}');
        return sb.toString();
    }
    
    

}
