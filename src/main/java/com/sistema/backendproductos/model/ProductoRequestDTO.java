package com.sistema.backendproductos.model;

import lombok.Data;

@Data
public class ProductoRequestDTO {
    private String nombre;
    private double precio;
    private int stock;
}