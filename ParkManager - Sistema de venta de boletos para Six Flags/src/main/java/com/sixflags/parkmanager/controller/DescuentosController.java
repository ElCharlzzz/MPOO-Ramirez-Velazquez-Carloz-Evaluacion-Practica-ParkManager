package com.sixflags.parkmanager.controller;

import com.sixflags.parkmanager.dto.DescuentoRequest;
import com.sixflags.parkmanager.service.ParkManagerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/descuentos")
public class DescuentosController {

    private final ParkManagerService service;

    public DescuentosController(ParkManagerService service) {
        this.service = service;
    }

    @PutMapping("/{tipo}")
    public Map<String, Object> configurarDescuento(
            @PathVariable String tipo, 
            @Valid @RequestBody DescuentoRequest request) {
        return service.configurarDescuento(tipo.toUpperCase(), request.getPorcentaje());
    }

    @DeleteMapping("/{tipo}")
    public void removerDescuento(@PathVariable String tipo) {
        service.removerDescuento(tipo.toUpperCase());
    }
}