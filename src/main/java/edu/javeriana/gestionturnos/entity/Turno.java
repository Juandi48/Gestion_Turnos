package edu.javeriana.gestionturnos.entity;

import edu.javeriana.gestionturnos.enums.EstadoTurno;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "turnos")
public class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La fecha es obligatoria.")
    @Column(nullable = false)
    private LocalDate fecha;

    @NotNull(message = "La hora de inicio es obligatoria.")
    @Column(nullable = false)
    private LocalTime horaInicio;

    @NotNull(message = "La hora de fin es obligatoria.")
    @Column(nullable = false)
    private LocalTime horaFin;

    @NotNull(message = "El estado del turno es obligatorio.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private EstadoTurno estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "docente_id", nullable = false)
    @NotNull(message = "El docente es obligatorio.")
    private Docente docente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "zona_id", nullable = false)
    @NotNull(message = "La zona es obligatoria.")
    private Zona zona;

    @OneToMany(mappedBy = "turno", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Incidente> incidentes = new ArrayList<>();

    @OneToMany(mappedBy = "turno", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Notificacion> notificaciones = new ArrayList<>();

    @OneToMany(mappedBy = "turnoOriginal", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Reemplazo> reemplazos = new ArrayList<>();

    public Turno() {
    }

    public Turno(Long id, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, EstadoTurno estado, Docente docente, Zona zona) {
        this.id = id;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.estado = estado;
        this.docente = docente;
        this.zona = zona;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public EstadoTurno getEstado() {
        return estado;
    }

    public Docente getDocente() {
        return docente;
    }

    public Zona getZona() {
        return zona;
    }

    public List<Incidente> getIncidentes() {
        return incidentes;
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public List<Reemplazo> getReemplazos() {
        return reemplazos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public void setEstado(EstadoTurno estado) {
        this.estado = estado;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public void setIncidentes(List<Incidente> incidentes) {
        this.incidentes = incidentes;
    }

    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public void setReemplazos(List<Reemplazo> reemplazos) {
        this.reemplazos = reemplazos;
    }
}