package edu.javeriana.gestionturnos.dto;

public class ReemplazoSugeridoDTO {

    private Long docenteId;
    private String nombreCompletoDocente;
    private String correoDocente;
    private Integer cargaTurnos;
    private Boolean disponible;
    private String criterioSugerencia;

    public ReemplazoSugeridoDTO() {
    }

    public ReemplazoSugeridoDTO(Long docenteId,
                                String nombreCompletoDocente,
                                String correoDocente,
                                Integer cargaTurnos,
                                Boolean disponible,
                                String criterioSugerencia) {
        this.docenteId = docenteId;
        this.nombreCompletoDocente = nombreCompletoDocente;
        this.correoDocente = correoDocente;
        this.cargaTurnos = cargaTurnos;
        this.disponible = disponible;
        this.criterioSugerencia = criterioSugerencia;
    }

    public Long getDocenteId() {
        return docenteId;
    }

    public void setDocenteId(Long docenteId) {
        this.docenteId = docenteId;
    }

    public String getNombreCompletoDocente() {
        return nombreCompletoDocente;
    }

    public void setNombreCompletoDocente(String nombreCompletoDocente) {
        this.nombreCompletoDocente = nombreCompletoDocente;
    }

    public String getCorreoDocente() {
        return correoDocente;
    }

    public void setCorreoDocente(String correoDocente) {
        this.correoDocente = correoDocente;
    }

    public Integer getCargaTurnos() {
        return cargaTurnos;
    }

    public void setCargaTurnos(Integer cargaTurnos) {
        this.cargaTurnos = cargaTurnos;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public String getCriterioSugerencia() {
        return criterioSugerencia;
    }

    public void setCriterioSugerencia(String criterioSugerencia) {
        this.criterioSugerencia = criterioSugerencia;
    }
}