package edu.javeriana.gestionturnos.enums;

public enum TipoIncidente {

    SEGURIDAD("Incidente de Seguridad"),
    INFRAESTRUCTURA("Problema de Infraestructura"),
    ACCIDENTE("Accidente"),
    EMERGENCIA_MEDICA("Emergencia Médica"),
    FALLA_TECNICA("Falla Técnica"),
    OTRO("Otro");

    private final String descripcion;

    TipoIncidente(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}