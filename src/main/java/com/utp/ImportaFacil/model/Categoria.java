package com.utp.ImportaFacil.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;

    @NotBlank(message = "El nombre de la categoría es obligatorio.")
    @Size(min = 3, max = 50, message = "El nombre debe tener entre 3 and 50 caracteres.")
    @Column(nullable = false, unique = true, length = 50)
    private String nombre;

    @NotBlank(message = "El color es obligatorio.")
    @Column(length = 20)
    private String color;

    public Categoria() {}

    public Categoria(Long id, String nombre, String color) {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
}
