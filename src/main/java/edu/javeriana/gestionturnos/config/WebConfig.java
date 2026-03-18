package edu.javeriana.gestionturnos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Espacio reservado para vistas directas sin controller.
        // Ejemplo:
        // registry.addViewController("/acceso-denegado").setViewName("error/403");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // Aquí puedes registrar convertidores personalizados más adelante.
        // Por ejemplo, convertir String a entidades si lo necesitas en formularios.
    }
}