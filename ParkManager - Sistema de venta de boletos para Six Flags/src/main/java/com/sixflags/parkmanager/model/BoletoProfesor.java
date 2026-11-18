package com.sixflags.parkmanager.model;

public class BoletoProfesor extends Boleto {
    @Override
    public double getPrecioBase() {
        return 700.00;
    }

    @Override
    public String getTipoNombre() {
        return "PROFESOR";
    }
}