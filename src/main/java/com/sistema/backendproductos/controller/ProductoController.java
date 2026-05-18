package com.sistema.backendproductos.controller;

import com.sistema.backendproductos.model.*;
import com.sistema.backendproductos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoRepository repository;

    // Obtener todos los productos mapeados a DTOs
    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductoResponseDTO>>> listarTodos() {
        List<Producto> productos = repository.findAll();
        List<ProductoResponseDTO> dtos = new ArrayList<>();

        for (Producto p : productos) {
            ProductoResponseDTO dto = new ProductoResponseDTO();
            dto.setId(p.getId());
            dto.setNombre(p.getNombre());
            dto.setPrecio(p.getPrecio());
            dto.setStock(p.getStock());
            dtos.add(dto);
        }

        ApiResponse<List<ProductoResponseDTO>> respuesta = new ApiResponse<>(true, dtos, "Productos obtenidos correctamente");
        return ResponseEntity.ok(respuesta);
    }

    // Crear producto usando RequestDTO
    @PostMapping
    public ResponseEntity<ApiResponse<ProductoResponseDTO>> crearProducto(@RequestBody ProductoRequestDTO request) {
        // Pasar de DTO a Entidad para guardar en Docker
        Producto producto = new Producto();
        producto.setNombre(request.getNombre());
        producto.setPrecio(request.getPrecio());
        producto.setStock(request.getStock());

        Producto guardado = repository.save(producto);

        // Pasar de Entidad guardada a ResponseDTO para Flutter
        ProductoResponseDTO responseDTO = new ProductoResponseDTO();
        responseDTO.setId(guardado.getId());
        responseDTO.setNombre(guardado.getNombre());
        responseDTO.setPrecio(guardado.getPrecio());
        responseDTO.setStock(guardado.getStock());

        ApiResponse<ProductoResponseDTO> respuesta = new ApiResponse<>(true, responseDTO, "Producto creado con éxito");
        return ResponseEntity.ok(respuesta);
    }


    
// Buscar un producto por ID (Para probar el manejo de excepciones)
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProductoResponseDTO>> buscarPorId(@PathVariable Long id) {
        // Si el ID no existe en la base de datos de Docker, lanzamos el error intencionalmente
        Producto p = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("El producto con ID " + id + " no existe."));

        ProductoResponseDTO dto = new ProductoResponseDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setPrecio(p.getPrecio());
        dto.setStock(p.getStock());

        ApiResponse<ProductoResponseDTO> respuesta = new ApiResponse<>(true, dto, "Producto encontrado");
        return ResponseEntity.ok(respuesta);
    }


}


