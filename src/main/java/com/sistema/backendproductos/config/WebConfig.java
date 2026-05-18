package com.sistema.backendproductos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // Le dice a Spring que esto es un archivo de configuración del sistema
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permitir CORS en todas las rutas de la API
                .allowedOrigins("http://localhost:*", "http://127.0.0.1:*") // Permitir cualquier puerto local de Flutter
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS") // Métodos permitidos
                .allowedHeaders("*") // Permitir cualquier cabecera (necesario para cuando usemos JWT)
                .allowCredentials(true);
    }
}