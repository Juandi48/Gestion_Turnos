package edu.javeriana.gestionturnos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "docentes")
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio.")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio.")
    @Column(nullable = false, length = 100)
    private String apellido;

    @NotBlank(message = "El correo es obligatorio.")
    @Email(message = "Debe ingresar un correo válido.")
    @Column(nullable = false, unique = true, length = 150)
    private String correo;

    @NotNull(message = "El estado activo es obligatorio.")
    @Column(nullable = false)
    private Boolean activo = true;

    @NotNull(message = "La carga de turnos es obligatoria.")
    @Column(nullable = false)
    private Integer cargaTurnos = 0;

    @OneToMany(mappedBy = "docente", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Turno> turnos = new ArrayList<>();

    @OneToMany(mappedBy = "docenteReporta", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Incidente> incidentesReportados = new ArrayList<>();

    @OneToMany(mappedBy = "docenteOriginal", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Reemplazo> reemplazosSolicitados = new ArrayList<>();

    @OneToMany(mappedBy = "docenteReemplazo", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Reemplazo> reemplazosAsignados = new ArrayList<>();

    @OneToOne(mappedBy = "docente", cascade = CascadeType.ALL)
    private Usuario usuario;

    public Docente() {
    }

    public Docente(Long id, String nombre, String apellido, String correo, Boolean activo, Integer cargaTurnos) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.activo = activo;
        this.cargaTurnos = cargaTurnos;
    }

    public String getNombreCompleto() {
        return (nombre != null ? nombre : "") + " " + (apellido != null ? apellido : "");
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public Integer getCargaTurnos() {
        return cargaTurnos;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public List<Incidente> getIncidentesReportados() {
        return incidentesReportados;
    }

    public List<Reemplazo> getReemplazosSolicitados() {
        return reemplazosSolicitados;
    }

    public List<Reemplazo> getReemplazosAsignados() {
        return reemplazosAsignados;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public void setCargaTurnos(Integer cargaTurnos) {
        this.cargaTurnos = cargaTurnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public void setIncidentesReportados(List<Incidente> incidentesReportados) {
        this.incidentesReportados = incidentesReportados;
    }

    public void setReemplazosSolicitados(List<Reemplazo> reemplazosSolicitados) {
        this.reemplazosSolicitados = reemplazosSolicitados;
    }

    public void setReemplazosAsignados(List<Reemplazo> reemplazosAsignados) {
        this.reemplazosAsignados = reemplazosAsignados;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}