package com.utp.ImportaFacil.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "perfiles_premium")
public class PerfilPremium {

    @Id
    @Column(name = "id_usuario")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @NotNull(message = "La cantidad de puntos es obligatoria.")
    @Min(value = 0, message = "Los puntos no pueden ser negativos.")
    @Column(name = "cantidad_puntos", nullable = false)
    private int cantidadPuntos;

    @NotNull(message = "La fecha de vencimiento es obligatoria.")
    @Future(message = "La fecha de vencimiento debe ser una fecha futura.")
    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDate fechaVencimiento;

    public PerfilPremium() {}

    public PerfilPremium(Long id, Usuario usuario, int cantidadPuntos, LocalDate fechaVencimiento) {
        this.id = id;
        this.usuario = usuario;
        this.cantidadPuntos = cantidadPuntos;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public int getCantidadPuntos() { return cantidadPuntos; }
    public void setCantidadPuntos(int cantidadPuntos) { this.cantidadPuntos = cantidadPuntos; }

    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
}
