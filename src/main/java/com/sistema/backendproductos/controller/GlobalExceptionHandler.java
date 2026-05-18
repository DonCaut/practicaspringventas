package com.sistema.backendproductos.controller;

import com.sistema.backendproductos.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

@RestControllerAdvice(basePackages = "com.sistema.backendproductos.controller")
public class GlobalExceptionHandler {

    // Este método se activa si lanzamos un RuntimeException (ej. Producto no encontrado)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> manejarRuntimeException(RuntimeException ex) {
        
        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(), // Código 400
                ex.getMessage(),
                LocalDateTime.now()
        );
        
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}