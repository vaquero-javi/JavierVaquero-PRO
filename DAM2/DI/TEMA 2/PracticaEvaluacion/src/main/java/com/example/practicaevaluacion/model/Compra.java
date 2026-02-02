package com.example.practicaevaluacion.model;

import java.time.LocalDateTime;

public class Compra {
    private int id;
    private int usuarioId;
    private int productoId;
    private int cantidad;
    private LocalDateTime fechaCompra;

    public Compra() {}

    public Compra(int usuarioId, int productoId, int cantidad) {
        this.usuarioId = usuarioId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.fechaCompra = LocalDateTime.now();
    }

    public Compra(int id, int usuarioId, int productoId, int cantidad, LocalDateTime fechaCompra) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.fechaCompra = fechaCompra;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public int getProductoId() { return productoId; }
    public void setProductoId(int productoId) { this.productoId = productoId; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public LocalDateTime getFechaCompra() { return fechaCompra; }
    public void setFechaCompra(LocalDateTime fechaCompra) { this.fechaCompra = fechaCompra; }
}