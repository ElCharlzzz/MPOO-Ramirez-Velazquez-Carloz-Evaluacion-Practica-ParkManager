package com.sixflags.parkmanager.dto;

import jakarta.validation.constraints.NotNull;

public class DescuentoRequest {
    
    @NotNull(message = "El campo porcentaje es obligatorio")
    private Integer porcentaje;

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }
}