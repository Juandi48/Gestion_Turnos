package edu.javeriana.gestionturnos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zonas")
public class Zona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la zona es obligatorio.")
    @Column(nullable = false, unique = true, length = 120)
    private String nombre;

    @Column(length = 255)
    private String descripcion;

    @Column(length = 50)
    private String bloque;

    @NotNull(message = "El estado de la zona es obligatorio.")
    @Column(nullable = false)
    private Boolean activa = true;

    @OneToMany(mappedBy = "zona", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Turno> turnos = new ArrayList<>();

    @OneToMany(mappedBy = "zona", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Incidente> incidentes = new ArrayList<>();

    @OneToMany(mappedBy = "zona", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Notificacion> notificaciones = new ArrayList<>();

    public Zona() {
    }

    public Zona(Long id, String nombre, String descripcion, String bloque, Boolean activa) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.bloque = bloque;
        this.activa = activa;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getBloque() {
        return bloque;
    }

    public Boolean getActiva() {
        return activa;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public List<Incidente> getIncidentes() {
        return incidentes;
    }

    public List<Notificacion> getNotificaciones() {
        return notificaciones;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setBloque(String bloque) {
        this.bloque = bloque;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public void setIncidentes(List<Incidente> incidentes) {
        this.incidentes = incidentes;
    }

    public void setNotificaciones(List<Notificacion> notificaciones) {
        this.notificaciones = notificaciones;
    }
}