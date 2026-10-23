package com.utp.ImportaFacil.model;

public class PerfilPremium {
    private Long idUsuario;
    private int cantidadPuntos;
    private String fechaVencimiento;

    public PerfilPremium() {}

    public PerfilPremium(Long idUsuario, int cantidadPuntos, String fechaVencimiento) {
        this.idUsuario = idUsuario;
        this.cantidadPuntos = cantidadPuntos;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
    public int getCantidadPuntos() { return cantidadPuntos; }
    public void setCantidadPuntos(int cantidadPuntos) { this.cantidadPuntos = cantidadPuntos; }
    public String getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
}
