package edu.javeriana.gestionturnos.service.impl;

import edu.javeriana.gestionturnos.dto.IncidentePorZonaDTO;
import edu.javeriana.gestionturnos.entity.Incidente;
import edu.javeriana.gestionturnos.entity.Reemplazo;
import edu.javeriana.gestionturnos.entity.Turno;
import edu.javeriana.gestionturnos.entity.Zona;
import edu.javeriana.gestionturnos.repository.IncidenteRepository;
import edu.javeriana.gestionturnos.repository.ReemplazoRepository;
import edu.javeriana.gestionturnos.repository.TurnoRepository;
import edu.javeriana.gestionturnos.repository.ZonaRepository;
import edu.javeriana.gestionturnos.service.ReporteService;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReporteServiceImpl implements ReporteService {

    private final IncidenteRepository incidenteRepository;
    private final ZonaRepository zonaRepository;
    private final TurnoRepository turnoRepository;
    private final ReemplazoRepository reemplazoRepository;

    public ReporteServiceImpl(IncidenteRepository incidenteRepository,
                              ZonaRepository zonaRepository,
                              TurnoRepository turnoRepository,
                              ReemplazoRepository reemplazoRepository) {
        this.incidenteRepository = incidenteRepository;
        this.zonaRepository = zonaRepository;
        this.turnoRepository = turnoRepository;
        this.reemplazoRepository = reemplazoRepository;
    }

    @Override
    public List<IncidentePorZonaDTO> obtenerIncidentesPorZona() {
        List<Incidente> incidentes = incidenteRepository.findAll();
        List<Zona> zonas = zonaRepository.findAll();

        return zonas.stream()
                .map(zona -> {
                    long cantidad = incidentes.stream()
                            .filter(incidente -> incidente.getZona() != null
                                    && incidente.getZona().getId().equals(zona.getId()))
                            .count();

                    return new IncidentePorZonaDTO(
                            zona.getNombre(),
                            cantidad,
                            0.0
                    );
                })
                .toList();
    }

    @Override
    public Map<String, Long> obtenerTurnosPorEstado() {
        List<Turno> turnos = turnoRepository.findAll();
        Map<String, Long> resultado = new LinkedHashMap<>();

        for (Turno turno : turnos) {
            String estado = turno.getEstado() != null ? turno.getEstado().name() : "SIN_ESTADO";
            resultado.put(estado, resultado.getOrDefault(estado, 0L) + 1);
        }

        return resultado;
    }

    @Override
    public Map<String, Long> obtenerReemplazosPorEstado() {
        List<Reemplazo> reemplazos = reemplazoRepository.findAll();
        Map<String, Long> resultado = new LinkedHashMap<>();

        for (Reemplazo reemplazo : reemplazos) {
            String estado = reemplazo.getEstado() != null ? reemplazo.getEstado().name() : "SIN_ESTADO";
            resultado.put(estado, resultado.getOrDefault(estado, 0L) + 1);
        }

        return resultado;
    }

    @Override
    public List<IncidentePorZonaDTO> obtenerPorcentajeIncidentesPorZona() {
        List<Incidente> incidentes = incidenteRepository.findAll();
        List<Zona> zonas = zonaRepository.findAll();

        long totalIncidentes = incidentes.size();

        return zonas.stream()
                .map(zona -> {
                    long cantidad = incidentes.stream()
                            .filter(incidente -> incidente.getZona() != null
                                    && incidente.getZona().getId().equals(zona.getId()))
                            .count();

                    double porcentaje = totalIncidentes > 0
                            ? (cantidad * 100.0) / totalIncidentes
                            : 0.0;

                    return new IncidentePorZonaDTO(
                            zona.getNombre(),
                            cantidad,
                            porcentaje
                    );
                })
                .toList();
    }
}