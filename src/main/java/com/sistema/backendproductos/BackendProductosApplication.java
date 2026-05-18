package com.sistema.backendproductos;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(title = "API de Productos", version = "1.0", description = "Documentacion segura con JWT"),
    // Esto le dice a Swagger que absolutamente todos los endpoints requieren seguridad por defecto
    security = @SecurityRequirement(name = "BearerAuth") 
)
@SecurityScheme(
    name = "BearerAuth",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "JWT",
    description = "Introduce tu token JWT en el formato: Bearer [tu_token]"
)
public class BackendProductosApplication { // Tu clase principal

    public static void main(String[] args) {
        SpringApplication.run(BackendProductosApplication.class, args);
    }
}