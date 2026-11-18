package com.sixflags.parkmanager.exception;

import com.sixflags.parkmanager.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ParkManagerException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleNegocioException(ParkManagerException ex) {
        return new ErrorResponse(ex.getCodigo(), ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidaciones(MethodArgumentNotValidException ex) {
        return new ErrorResponse("SOLICITUD_INVALIDA", "Solicitud sin campos obligatorios o mal formada");
    }
}