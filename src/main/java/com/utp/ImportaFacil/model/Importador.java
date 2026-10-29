package com.utp.ImportaFacil.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "importadores")
public class Importador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_importador")
    private Long id;

    @NotBlank(message = "El nombre de la empresa es obligatorio.")
    @Size(min = 3, max = 100, message = "El nombre de la empresa debe tener entre 3 y 100 caracteres.")
    @Column(name = "nombre_empresa", nullable = false, length = 100)
    private String nombreEmpresa;

    @NotBlank(message = "El correo electrónico es obligatorio.")
    @Email(message = "Debe ingresar un formato de correo válido.")
    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    @NotBlank(message = "El teléfono es obligatorio.")
    @Pattern(regexp = "^\\+?[0-9]{9,15}$", message = "El teléfono debe contener entre 9 y 15 dígitos numéricos.")
    @Column(length = 15)
    private String telefono;

    @NotBlank(message = "La dirección es obligatoria.")
    @Size(max = 255, message = "La dirección no puede exceder los 255 caracteres.")
    @Column(length = 255)
    private String direccion;

    @NotBlank(message = "El estado es obligatorio.")
    @Column(length = 20)
    private String estado;

    public Importador() {}

    public Importador(Long id, String nombreEmpresa, String correo, String telefono, String direccion, String estado) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.estado = estado;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

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
