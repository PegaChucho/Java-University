package paquete1;

class Clase1 {

    private String atributoprivado = "Valor atributo privado";

    private Clase1() {
        System.out.println("Constructor privado");
    }

    public Clase1(String arg) {
        this();
        System.out.println("Constructor público");
    }

    private void metodoPublico() {
        System.out.println("Método default");
        System.out.println("atributo = " + this.atributoprivado);
    }

    public String getAtributoprivado() {
        return atributoprivado;
    }

    public void setAtributoprivado(String atributoprivado) {
        this.atributoprivado = atributoprivado;
    }
    
}
