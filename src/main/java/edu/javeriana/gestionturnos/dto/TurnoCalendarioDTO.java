package edu.javeriana.gestionturnos.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class TurnoCalendarioDTO {

    private Long turnoId;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String nombreDocente;
    private String nombreZona;
    private String estadoTurno;
    private String colorEstado;

    public TurnoCalendarioDTO() {
    }

    public TurnoCalendarioDTO(Long turnoId,
                              LocalDate fecha,
                              LocalTime horaInicio,
                              LocalTime horaFin,
                              String nombreDocente,
                              String nombreZona,
                              String estadoTurno) {
        this.turnoId = turnoId;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.nombreDocente = nombreDocente;
        this.nombreZona = nombreZona;
        this.estadoTurno = estadoTurno;
        this.colorEstado = calcularColorEstado(estadoTurno);
    }

    public Long getTurnoId() {
        return turnoId;
    }

    public void setTurnoId(Long turnoId) {
        this.turnoId = turnoId;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public String getEstadoTurno() {
        return estadoTurno;
    }

    public void setEstadoTurno(String estadoTurno) {
        this.estadoTurno = estadoTurno;
        this.colorEstado = calcularColorEstado(estadoTurno);
    }

    public String getColorEstado() {
        return colorEstado;
    }

    public void setColorEstado(String colorEstado) {
        this.colorEstado = colorEstado;
    }

    private String calcularColorEstado(String estadoTurno) {
        if (estadoTurno == null) {
            return "gris";
        }

        return switch (estadoTurno.toUpperCase()) {
            case "PROGRAMADO" -> "azul";
            case "PENDIENTE" -> "amarillo";
            case "CUBIERTO" -> "verde";
            case "CANCELADO" -> "rojo";
            default -> "gris";
        };
    }
}