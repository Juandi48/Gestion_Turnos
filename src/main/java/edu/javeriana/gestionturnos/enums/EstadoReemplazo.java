package edu.javeriana.gestionturnos.enums;

public enum EstadoReemplazo {

    SOLICITADO("Solicitado"),
    APROBADO("Aprobado"),
    RECHAZADO("Rechazado"),
    COMPLETADO("Completado");

    private final String descripcion;

    EstadoReemplazo(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}