package com.sixflags.parkmanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CompraRequest {

    @NotBlank(message = "Eltipo de boleto es obligatorio")
    private String tipo;

    @NotNull(message = "Lacantidad es obligatoria")
    private Integer cantidad;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}