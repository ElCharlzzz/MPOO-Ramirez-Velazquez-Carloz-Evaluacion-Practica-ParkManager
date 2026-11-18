package com.sixflags.parkmanager.controller;

import com.sixflags.parkmanager.dto.CompraRequest;
import com.sixflags.parkmanager.service.ParkManagerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/compras")
public class ComprasController {

    private final ParkManagerService service;

    public ComprasController(ParkManagerService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Esto devuelve automáticamente el HTTP 201
    public Map<String, Object> registrarCompra(@Valid @RequestBody CompraRequest request) {
        return service.registrarCompra(request.getTipo().toUpperCase(), request.getCantidad());
    }
}