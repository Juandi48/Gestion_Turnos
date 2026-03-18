package edu.javeriana.gestionturnos.entity;

import edu.javeriana.gestionturnos.enums.TipoNotificacion;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "notificaciones")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El mensaje de la notificación es obligatorio.")
    @Column(nullable = false, length = 255)
    private String mensaje;

    @NotNull(message = "La fecha y hora de envío es obligatoria.")
    @Column(nullable = false)
    private LocalDateTime fechaHoraEnvio;

    @NotNull(message = "El tipo de notificación es obligatorio.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 40)
    private TipoNotificacion tipo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "turno_id")
    private Turno turno;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "zona_id")
    private Zona zona;

    public Notificacion() {
    }

    public Notificacion(Long id, String mensaje, LocalDateTime fechaHoraEnvio, TipoNotificacion tipo, Turno turno, Zona zona) {
        this.id = id;
        this.mensaje = mensaje;
        this.fechaHoraEnvio = fechaHoraEnvio;
        this.tipo = tipo;
        this.turno = turno;
        this.zona = zona;
    }

    public Long getId() {
        return id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaHoraEnvio() {
        return fechaHoraEnvio;
    }

    public TipoNotificacion getTipo() {
        return tipo;
    }

    public Turno getTurno() {
        return turno;
    }

    public Zona getZona() {
        return zona;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setFechaHoraEnvio(LocalDateTime fechaHoraEnvio) {
        this.fechaHoraEnvio = fechaHoraEnvio;
    }

    public void setTipo(TipoNotificacion tipo) {
        this.tipo = tipo;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }
}