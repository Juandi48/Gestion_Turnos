package edu.javeriana.gestionturnos.enums;

public enum TipoNotificacion {

    INCIDENTE_REGISTRADO("Incidente Registrado"),
    CAMBIO_TURNO("Cambio de Turno"),
    SOLICITUD_REEMPLAZO("Solicitud de Reemplazo"),
    REEMPLAZO_APROBADO("Reemplazo Aprobado"),
    ALERTA_ZONA("Alerta de Zona");

    private final String descripcion;

    TipoNotificacion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}