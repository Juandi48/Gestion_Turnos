package edu.javeriana.gestionturnos.service;

import edu.javeriana.gestionturnos.dto.ReemplazoSugeridoDTO;
import edu.javeriana.gestionturnos.entity.Reemplazo;

import java.util.List;

public interface ReemplazoService {

    List<Reemplazo> findAll();

    Reemplazo findById(Long id);

    Reemplazo save(Reemplazo reemplazo);

    void deleteById(Long id);

    List<ReemplazoSugeridoDTO> obtenerSugerenciasPorTurno(Long turnoId);
}