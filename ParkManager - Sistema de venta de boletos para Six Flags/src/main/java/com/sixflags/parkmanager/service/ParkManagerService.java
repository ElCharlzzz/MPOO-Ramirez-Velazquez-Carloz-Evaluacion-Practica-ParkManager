package com.sixflags.parkmanager.service;

import com.sixflags.parkmanager.exception.ParkManagerException;
import com.sixflags.parkmanager.model.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ParkManagerService {
    
    private final Map<String, Boleto> modalidades;
    private double ingresosAcumulados = 0.0;

    public ParkManagerService() {
        modalidades = new HashMap<>();
        modalidades.put("GENERAL", new BoletoGeneral());
        modalidades.put("PASE_ANUAL", new BoletoPaseAnual());
        modalidades.put("ALUMNO", new BoletoAlumno());
        modalidades.put("PROFESOR", new BoletoProfesor());
    }

    private Boleto obtenerBoletoValidado(String tipo) {
        if (tipo == null || !modalidades.containsKey(tipo)) {
            throw new ParkManagerException("TIPO_BOLETO_INVALIDO", "Tipo distinto de las cuatro modalidades");
        }
        return modalidades.get(tipo);
    }

    public Map<String, Object> configurarDescuento(String tipo, int porcentaje) {
        if (porcentaje < 0 || porcentaje > 100) {
            throw new ParkManagerException("DESCUENTO_INVALIDO", "El porcentaje debe estar entre 0 y 100");
        }
        
        Boleto boleto = obtenerBoletoValidado(tipo);
        boleto.setPorcentajeDescuento(porcentaje);
        
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("tipo", tipo);
        response.put("porcentaje", porcentaje);
        response.put("mensaje", "Descuento configurado");
        return response;
    }

    public void removerDescuento(String tipo) {
        Boleto boleto = obtenerBoletoValidado(tipo);
        boleto.setPorcentajeDescuento(0);
    }

    public Map<String, Object> registrarCompra(String tipo, int cantidad) {
        if (cantidad < 1 || cantidad > 10) {
            throw new ParkManagerException("CANTIDAD_INVALIDA", "La cantidad de boletos debe estar entre 1 y 10");
        }

        Boleto boleto = obtenerBoletoValidado(tipo);
        
        double precioBase = boleto.getPrecioBase();
        int descuentoAplicado = boleto.getPorcentajeDescuento();
        double precioFinal = boleto.getPrecioUnitarioFinal();
        double totalCompra = precioFinal * cantidad;
        
        this.ingresosAcumulados += totalCompra;

        Map<String, Object> response = new LinkedHashMap<>();
        response.put("tipo", tipo);
        response.put("cantidad", cantidad);
        response.put("precioBase", precioBase);
        response.put("descuentoAplicado", descuentoAplicado);
        response.put("precioUnitarioFinal", precioFinal);
        response.put("total", totalCompra);
        response.put("ingresosAcumulados", this.ingresosAcumulados);
        
        return response;
    }
}