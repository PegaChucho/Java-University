package com.pegachucho.mundopc;

public class Raton extends DispositivoEntrada {

    private static int contadorRatones;
    private final int idRaton;

    public Raton(String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
        this.idRaton = ++contadorRatones;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(", Raton{idRaton=").append(idRaton);
        sb.append('}');
        return sb.toString();
    }

}
