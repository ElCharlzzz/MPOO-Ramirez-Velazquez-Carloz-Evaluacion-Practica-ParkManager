package com.sixflags.parkmanager.model;

public class BoletoPaseAnual extends Boleto {
    @Override
    public double getPrecioBase() {
        return 2400.00;
    }

    @Override
    public String getTipoNombre() {
        return "PASE_ANUAL";
    }
}