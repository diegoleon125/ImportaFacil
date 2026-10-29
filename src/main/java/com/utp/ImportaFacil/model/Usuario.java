package com.utp.ImportaFacil.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @NotBlank(message = "El nombre es obligatorio.")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 y 50 caracteres.")
    @Column(nullable = false, length = 50)
    private String nombre;

    @NotBlank(message = "El correo electrónico es obligatorio.")
    @Email(message = "Debe ingresar un formato de correo válido (ejemplo@correo.com).")
    @Column(nullable = false, unique = true, length = 100)
    private String correo;

    @NotBlank(message = "La password es obligatoria.")
    @Size(min = 6, message = "La password debe tener al menos 6 caracteres.")
    @Column(nullable = false) 
    private String password;

    @Column(length = 15)
    private String telefono;

    @Column(name = "fecha_registro", updatable = false)
    private LocalDateTime fechaRegistro;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private PerfilPremium perfilPremium;

    @PrePersist
    protected void onCreate() {
        this.fechaRegistro = LocalDateTime.now();
    }

    public Usuario() {}

    public Usuario(Long idUsuario, String nombre, String correo, String password, String telefono, LocalDateTime fechaRegistro, PerfilPremium perfilPremium) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.telefono = telefono;
        this.fechaRegistro = fechaRegistro;
        this.perfilPremium = perfilPremium;
    }

    public Long getId() { return idUsuario; }
    public void setId(Long idUsuario) { this.idUsuario = idUsuario; }
    
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    
    public PerfilPremium getPerfilPremium() { return perfilPremium; }
    public void setPerfilPremium(PerfilPremium perfilPremium) { this.perfilPremium = perfilPremium; }
}
