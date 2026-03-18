package edu.javeriana.gestionturnos.entity;

import edu.javeriana.gestionturnos.enums.SeveridadIncidente;
import edu.javeriana.gestionturnos.enums.TipoIncidente;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "incidentes")
public class Incidente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La fecha y hora del incidente es obligatoria.")
    @Column(nullable = false)
    private LocalDateTime fechaHora;

    @NotNull(message = "El tipo de incidente es obligatorio.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private TipoIncidente tipoIncidente;

    @NotNull(message = "La severidad del incidente es obligatoria.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SeveridadIncidente severidad;

    @NotBlank(message = "La descripción es obligatoria.")
    @Column(nullable = false, length = 500)
    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "zona_id", nullable = false)
    @NotNull(message = "La zona es obligatoria.")
    private Zona zona;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "turno_id", nullable = false)
    @NotNull(message = "El turno es obligatorio.")
    private Turno turno;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "docente_reporta_id", nullable = false)
    @NotNull(message = "El docente que reporta es obligatorio.")
    private Docente docenteReporta;

    public Incidente() {
    }

    public Incidente(Long id, LocalDateTime fechaHora, TipoIncidente tipoIncidente, SeveridadIncidente severidad,
                     String descripcion, Zona zona, Turno turno, Docente docenteReporta) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.tipoIncidente = tipoIncidente;
        this.severidad = severidad;
        this.descripcion = descripcion;
        this.zona = zona;
        this.turno = turno;
        this.docenteReporta = docenteReporta;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public TipoIncidente getTipoIncidente() {
        return tipoIncidente;
    }

    public SeveridadIncidente getSeveridad() {
        return severidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Zona getZona() {
        return zona;
    }

    public Turno getTurno() {
        return turno;
    }

    public Docente getDocenteReporta() {
        return docenteReporta;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public void setTipoIncidente(TipoIncidente tipoIncidente) {
        this.tipoIncidente = tipoIncidente;
    }

    public void setSeveridad(SeveridadIncidente severidad) {
        this.severidad = severidad;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public void setDocenteReporta(Docente docenteReporta) {
        this.docenteReporta = docenteReporta;
    }
}