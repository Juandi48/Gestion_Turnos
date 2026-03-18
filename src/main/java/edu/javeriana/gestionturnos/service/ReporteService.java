package edu.javeriana.gestionturnos.service;

import edu.javeriana.gestionturnos.dto.IncidentePorZonaDTO;

import java.util.List;
import java.util.Map;

public interface ReporteService {

    List<IncidentePorZonaDTO> obtenerIncidentesPorZona();

    Map<String, Long> obtenerTurnosPorEstado();

    Map<String, Long> obtenerReemplazosPorEstado();

    List<IncidentePorZonaDTO> obtenerPorcentajeIncidentesPorZona();
}