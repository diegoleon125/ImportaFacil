package com.utp.ImportaFacil.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "prod_importador")
public class ProdImportador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prod_importador")
    private Long id;

    @NotNull(message = "El importador es obligatorio.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_importador", nullable = false)
    private Importador importador;

    @NotNull(message = "El producto es obligatorio.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @NotNull(message = "El precio es obligatorio.")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0.")
    @Column(nullable = false)
    private double precio;

    @NotNull(message = "El stock es obligatorio.")
    @Min(value = 0, message = "El stock no puede ser negativo.")
    @Column(nullable = false)
    private int stock;

    public ProdImportador() {}

    public ProdImportador(Long id, Importador importador, Producto producto, double precio, int stock) {
        this.id = id;
        this.importador = importador;
        this.producto = producto;
        this.precio = precio;
        this.stock = stock;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Importador getImportador() { return importador; }
    public void setImportador(Importador importador) { this.importador = importador; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}
