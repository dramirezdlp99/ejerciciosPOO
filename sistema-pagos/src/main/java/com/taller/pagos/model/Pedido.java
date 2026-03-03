package com.taller.pagos.model;

public class Pedido {
    private Long id;
    private String descripcion;
    private double total;

    public Pedido(Long id, String descripcion, double total) {
        this.id = id;
        this.descripcion = descripcion;
        this.total = total;
    }

    public Long getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public double getTotal() { return total; }
}