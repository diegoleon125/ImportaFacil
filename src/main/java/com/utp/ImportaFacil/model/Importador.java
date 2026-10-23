package com.utp.ImportaFacil.model;

public class Importador {
    private Long idImportador;
    private String nombreEmpresa;
    private String correo;
    private String telefono;
    private String direccion;
    private String estado;

    public Importador() {}

    public Importador(Long idImportador, String nombreEmpresa, String correo, String telefono, String direccion, String estado) {
        this.idImportador = idImportador;
        this.nombreEmpresa = nombreEmpresa;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    }

    public Long getIdImportador() { return idImportador; }
    public void setIdImportador(Long idImportador) { this.idImportador = idImportador; }
    public String getNombreEmpresa() { return nombreEmpresa; }
    public void setNombreEmpresa(String nombreEmpresa) { this.nombreEmpresa = nombreEmpresa; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
