package com.utp.ImportaFacil.model;

public class ProdImportador {
    private Long id;
    private Importador importador;
    private Producto producto;
    private double precio;
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
