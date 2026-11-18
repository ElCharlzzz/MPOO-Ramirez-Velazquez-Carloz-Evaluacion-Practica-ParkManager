package com.sixflags.parkmanager.model;

public class BoletoAlumno extends Boleto {
    @Override
    public double getPrecioBase() {
        return 650.00;
    }

    @Override
    public String getTipoNombre() {
        return "ALUMNO";
    }
}