package edu.javeriana.gestionturnos.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFoundException(ResourceNotFoundException ex, Model model) {
        logger.error("Recurso no encontrado: {}", ex.getMessage());

        model.addAttribute("titulo", "Recurso no encontrado");
        model.addAttribute("mensaje", ex.getMessage());
        model.addAttribute("detalle", "El recurso solicitado no existe o ya no está disponible.");

        return "error/404";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handleIllegalArgumentException(IllegalArgumentException ex, Model model) {
        logger.error("Argumento inválido: {}", ex.getMessage());

        model.addAttribute("titulo", "Solicitud inválida");
        model.addAttribute("mensaje", ex.getMessage());
        model.addAttribute("detalle", "Se recibió un valor no válido en la operación solicitada.");

        return "error/error-general";
    }

    @ExceptionHandler(Exception.class)
    public String handleGeneralException(Exception ex, Model model) {
        logger.error("Error interno no controlado", ex);

        model.addAttribute("titulo", "Error interno del sistema");
        model.addAttribute("mensaje", "Ha ocurrido un error inesperado.");
        model.addAttribute("detalle", ex.getMessage());

        return "error/error-general";
    }
}