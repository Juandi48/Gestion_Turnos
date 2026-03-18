package edu.javeriana.gestionturnos.enums;

public enum EstadoTurno {

    PROGRAMADO("Programado"),
    PENDIENTE("Pendiente"),
    CUBIERTO("Cubierto"),
    CANCELADO("Cancelado");

    private final String etiqueta;

    EstadoTurno(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }
}