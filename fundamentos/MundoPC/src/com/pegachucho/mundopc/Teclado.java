package com.pegachucho.mundopc;

public class Teclado extends DispositivoEntrada {

    private static int contadorteclados;
    private final int idTeclado;

    public Teclado(String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
        this.idTeclado = ++contadorteclados;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", Teclado{idTeclado=").append(idTeclado);
        sb.append('}');
        return sb.toString();
    }

}
