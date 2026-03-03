package com.taller.pagos.model;

import java.time.LocalDate;

public class Pago {
    private Long id;
    private double monto;
    private LocalDate fecha;
    private String estado;
    private Pedido pedido;

    public Pago(Long id, double monto, LocalDate fecha, Pedido pedido) {
        this.id = id;
        this.monto = monto;
        this.fecha = fecha;
        this.pedido = pedido;
        this.estado = "PENDIENTE";
    }

    public void procesarPago() {
        if (validarMonto()) {
            cambiarEstado("PROCESADO");
        }
    }

    private boolean validarMonto() {
        return this.monto > 0;
    }

    private void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public Long getId() { return id; }
    public double getMonto() { return monto; }
    public String getEstado() { return estado; }
    public LocalDate getFecha() { return fecha; }
    public Pedido getPedido() { return pedido; }
}