package edu.javeriana.gestionturnos.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoaderConfig {

    private static final Logger logger = LoggerFactory.getLogger(DataLoaderConfig.class);

    @Bean
    public CommandLineRunner initDataLoader() {
        return args -> {
            logger.info("==============================================");
            logger.info("DataLoaderConfig inicializado correctamente.");
            logger.info("Aplicación web lista para configuración inicial.");
            logger.info("La carga de datos principal se manejará con Spring Batch.");
            logger.info("==============================================");
        };
    }
}