package domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.Instant;

public class Cliente extends Persona {

    private static int contadorCliente;

    private int idCliente;
    private boolean vip;
    private String fechaRegistro;

    public Cliente(Date fechaRegistro, boolean vip, String nombre, 
            char genero, int edad, String direccion) {
        super(nombre, genero, edad, direccion);
        this.idCliente = ++contadorCliente;
        this.vip = vip;
        SimpleDateFormat dateForm= new SimpleDateFormat("dd/MM/YY");
        this.fechaRegistro = dateForm.format(fechaRegistro);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{idCliente=").append(idCliente);
        sb.append(", vip=").append(vip);
        sb.append(", fechaRegistro=").append(fechaRegistro);
        sb.append(", ").append(super.toString());
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
}
