package com.sistema.backendproductos.repository;

import com.sistema.backendproductos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Método clave: Spring Data JPA creará la consulta SQL automáticamente
    Optional<Usuario> findByUsername(String username);
}