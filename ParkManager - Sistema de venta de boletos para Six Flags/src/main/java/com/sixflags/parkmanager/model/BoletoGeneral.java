package com.sixflags.parkmanager.model;

public class BoletoGeneral extends Boleto {
    @Override
    public double getPrecioBase() {
        return 900.00;
    }

    @Override
    public String getTipoNombre() {
        return "GENERAL";
    }
}