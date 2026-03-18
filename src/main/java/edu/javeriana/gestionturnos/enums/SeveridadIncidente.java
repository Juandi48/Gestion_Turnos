package edu.javeriana.gestionturnos.enums;

public enum SeveridadIncidente {

    BAJA("Baja"),
    MEDIA("Media"),
    ALTA("Alta"),
    CRITICA("Crítica");

    private final String descripcion;

    SeveridadIncidente(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}