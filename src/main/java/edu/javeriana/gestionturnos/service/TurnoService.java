package edu.javeriana.gestionturnos.service;

import edu.javeriana.gestionturnos.dto.TurnoCalendarioDTO;
import edu.javeriana.gestionturnos.entity.Turno;

import java.util.List;

public interface TurnoService {

    List<Turno> findAll();

    Turno findById(Long id);

    Turno save(Turno turno);

    void deleteById(Long id);

    List<TurnoCalendarioDTO> obtenerTurnosCalendario();
}