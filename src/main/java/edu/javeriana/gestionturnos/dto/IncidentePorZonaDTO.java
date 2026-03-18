package edu.javeriana.gestionturnos.dto;

public class IncidentePorZonaDTO {

    private String nombreZona;
    private Long cantidadIncidentes;
    private Double porcentajeIncidentes;
    private String nivelCriticidad;

    public IncidentePorZonaDTO() {
    }

    public IncidentePorZonaDTO(String nombreZona, Long cantidadIncidentes, Double porcentajeIncidentes) {
        this.nombreZona = nombreZona;
        this.cantidadIncidentes = cantidadIncidentes;
        this.porcentajeIncidentes = porcentajeIncidentes;
        this.nivelCriticidad = calcularNivelCriticidad(porcentajeIncidentes);
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public Long getCantidadIncidentes() {
        return cantidadIncidentes;
    }

    public void setCantidadIncidentes(Long cantidadIncidentes) {
        this.cantidadIncidentes = cantidadIncidentes;
    }

    public Double getPorcentajeIncidentes() {
        return porcentajeIncidentes;
    }

    public void setPorcentajeIncidentes(Double porcentajeIncidentes) {
        this.porcentajeIncidentes = porcentajeIncidentes;
        this.nivelCriticidad = calcularNivelCriticidad(porcentajeIncidentes);
    }

    public String getNivelCriticidad() {
        return nivelCriticidad;
    }

    public void setNivelCriticidad(String nivelCriticidad) {
        this.nivelCriticidad = nivelCriticidad;
    }

    private String calcularNivelCriticidad(Double porcentaje) {
        if (porcentaje == null) {
            return "SIN DATOS";
        }

        if (porcentaje < 20) {
            return "BAJO";
        } else if (porcentaje < 50) {
            return "MEDIO";
        } else {
            return "ALTO";
        }
    }
}