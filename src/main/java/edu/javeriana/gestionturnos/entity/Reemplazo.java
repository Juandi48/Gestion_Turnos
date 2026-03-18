package edu.javeriana.gestionturnos.entity;

import edu.javeriana.gestionturnos.enums.EstadoReemplazo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "reemplazos")
public class Reemplazo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La fecha de solicitud es obligatoria.")
    @Column(nullable = false)
    private LocalDateTime fechaSolicitud;

    @NotBlank(message = "El motivo del reemplazo es obligatorio.")
    @Column(nullable = false, length = 300)
    private String motivo;

    @NotNull(message = "El estado del reemplazo es obligatorio.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private EstadoReemplazo estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "turno_original_id", nullable = false)
    @NotNull(message = "El turno original es obligatorio.")
    private Turno turnoOriginal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "docente_original_id", nullable = false)
    @NotNull(message = "El docente original es obligatorio.")
    private Docente docenteOriginal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "docente_reemplazo_id")
    private Docente docenteReemplazo;

    public Reemplazo() {
    }

    public Reemplazo(Long id, LocalDateTime fechaSolicitud, String motivo, EstadoReemplazo estado,
                     Turno turnoOriginal, Docente docenteOriginal, Docente docenteReemplazo) {
        this.id = id;
        this.fechaSolicitud = fechaSolicitud;
        this.motivo = motivo;
        this.estado = estado;
        this.turnoOriginal = turnoOriginal;
        this.docenteOriginal = docenteOriginal;
        this.docenteReemplazo = docenteReemplazo;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFechaSolicitud() {
        return fechaSolicitud;
    }

    public String getMotivo() {
        return motivo;
    }

    public EstadoReemplazo getEstado() {
        return estado;
    }

    public Turno getTurnoOriginal() {
        return turnoOriginal;
    }

    public Docente getDocenteOriginal() {
        return docenteOriginal;
    }

    public Docente getDocenteReemplazo() {
        return docenteReemplazo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFechaSolicitud(LocalDateTime fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public void setEstado(EstadoReemplazo estado) {
        this.estado = estado;
    }

    public void setTurnoOriginal(Turno turnoOriginal) {
        this.turnoOriginal = turnoOriginal;
    }

    public void setDocenteOriginal(Docente docenteOriginal) {
        this.docenteOriginal = docenteOriginal;
    }

    public void setDocenteReemplazo(Docente docenteReemplazo) {
        this.docenteReemplazo = docenteReemplazo;
    }
}