package edu.javeriana.gestionturnos.service.impl;

import edu.javeriana.gestionturnos.dto.ReemplazoSugeridoDTO;
import edu.javeriana.gestionturnos.entity.Docente;
import edu.javeriana.gestionturnos.entity.Reemplazo;
import edu.javeriana.gestionturnos.entity.Turno;
import edu.javeriana.gestionturnos.exception.ResourceNotFoundException;
import edu.javeriana.gestionturnos.repository.DocenteRepository;
import edu.javeriana.gestionturnos.repository.ReemplazoRepository;
import edu.javeriana.gestionturnos.repository.TurnoRepository;
import edu.javeriana.gestionturnos.service.ReemplazoService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ReemplazoServiceImpl implements ReemplazoService {

    private final ReemplazoRepository reemplazoRepository;
    private final TurnoRepository turnoRepository;
    private final DocenteRepository docenteRepository;

    public ReemplazoServiceImpl(ReemplazoRepository reemplazoRepository,
                                TurnoRepository turnoRepository,
                                DocenteRepository docenteRepository) {
        this.reemplazoRepository = reemplazoRepository;
        this.turnoRepository = turnoRepository;
        this.docenteRepository = docenteRepository;
    }

    @Override
    public List<Reemplazo> findAll() {
        return reemplazoRepository.findAll();
    }

    @Override
    public Reemplazo findById(Long id) {
        return reemplazoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el reemplazo con id: " + id));
    }

    @Override
    public Reemplazo save(Reemplazo reemplazo) {
        return reemplazoRepository.save(reemplazo);
    }

    @Override
    public void deleteById(Long id) {
        if (!reemplazoRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se puede eliminar. No existe el reemplazo con id: " + id);
        }
        reemplazoRepository.deleteById(id);
    }

    @Override
    public List<ReemplazoSugeridoDTO> obtenerSugerenciasPorTurno(Long turnoId) {
        Turno turno = turnoRepository.findById(turnoId)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el turno con id: " + turnoId));

        List<Docente> docentesActivos = docenteRepository.findByActivoTrue();

        return docentesActivos.stream()
                .filter(docente -> turno.getDocente() == null || !docente.getId().equals(turno.getDocente().getId()))
                .filter(docente -> estaDisponible(docente, turno))
                .sorted(Comparator.comparing(docente -> docente.getCargaTurnos() != null ? docente.getCargaTurnos() : 0))
                .map(docente -> new ReemplazoSugeridoDTO(
                        docente.getId(),
                        docente.getNombreCompleto(),
                        docente.getCorreo(),
                        docente.getCargaTurnos(),
                        true,
                        "Disponible en la franja y con menor carga de turnos"
                ))
                .toList();
    }

    private boolean estaDisponible(Docente docente, Turno turnoObjetivo) {
        List<Turno> turnosDelDia = turnoRepository.findByDocenteAndFecha(docente, turnoObjetivo.getFecha());

        return turnosDelDia.stream().noneMatch(turnoExistente ->
                seCruzanHorarios(
                        turnoExistente.getHoraInicio().toSecondOfDay(),
                        turnoExistente.getHoraFin().toSecondOfDay(),
                        turnoObjetivo.getHoraInicio().toSecondOfDay(),
                        turnoObjetivo.getHoraFin().toSecondOfDay()
                )
        );
    }

    private boolean seCruzanHorarios(int inicioA, int finA, int inicioB, int finB) {
        return inicioA < finB && inicioB < finA;
    }
}