package com.pegachucho.mundopc;

public class Monitor {

    private static int contadorMonitores;
    private final int idMonitor;
    private String marca;
    private double tamaño;

    public Monitor() {
        this.idMonitor = ++contadorMonitores;
    }

    public Monitor(String marca, double tamaño) {
        this();
        this.marca = marca;
        this.tamaño = tamaño;
    }

    public int getIdMonitor() {
        return idMonitor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Monitor{marca=").append(marca);
        sb.append(", tama\u00f1o=").append(tamaño).append('"');
        sb.append('}');
        return sb.toString();
    }

}
