package edu.javeriana.gestionturnos.service.impl;

import edu.javeriana.gestionturnos.dto.TurnoCalendarioDTO;
import edu.javeriana.gestionturnos.entity.Turno;
import edu.javeriana.gestionturnos.exception.ResourceNotFoundException;
import edu.javeriana.gestionturnos.repository.TurnoRepository;
import edu.javeriana.gestionturnos.service.TurnoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoServiceImpl implements TurnoService {

    private final TurnoRepository turnoRepository;

    public TurnoServiceImpl(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Override
    public List<Turno> findAll() {
        return turnoRepository.findAll();
    }

    @Override
    public Turno findById(Long id) {
        return turnoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el turno con id: " + id));
    }

    @Override
    public Turno save(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public void deleteById(Long id) {
        if (!turnoRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se puede eliminar. No existe el turno con id: " + id);
        }
        turnoRepository.deleteById(id);
    }

    @Override
    public List<TurnoCalendarioDTO> obtenerTurnosCalendario() {
        return turnoRepository.findAll()
                .stream()
                .map(turno -> new TurnoCalendarioDTO(
                        turno.getId(),
                        turno.getFecha(),
                        turno.getHoraInicio(),
                        turno.getHoraFin(),
                        turno.getDocente() != null ? turno.getDocente().getNombreCompleto() : "Sin docente",
                        turno.getZona() != null ? turno.getZona().getNombre() : "Sin zona",
                        turno.getEstado() != null ? turno.getEstado().name() : null
                ))
                .toList();
    }
}