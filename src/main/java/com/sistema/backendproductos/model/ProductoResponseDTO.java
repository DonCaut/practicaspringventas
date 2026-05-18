package com.sistema.backendproductos.model;

import lombok.Data;

@Data
public class ProductoResponseDTO {
    private Long id;
    private String nombre;
    private double precio;
    private int stock;
}