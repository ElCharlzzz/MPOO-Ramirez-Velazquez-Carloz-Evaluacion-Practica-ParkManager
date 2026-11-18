package com.sixflags.parkmanager.model;

public abstract class Boleto {
    private int porcentajeDescuento = 0;

    public abstract double getPrecioBase();
    public abstract String getTipoNombre();

    public int getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(int porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public double getPrecioUnitarioFinal() {
        double precio = getPrecioBase() * (1.0 - (this.porcentajeDescuento / 100.0));
        return Math.round(precio * 100.0) / 100.0;
    }
}