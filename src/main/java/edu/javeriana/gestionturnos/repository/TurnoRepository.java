package edu.javeriana.gestionturnos.repository;

import edu.javeriana.gestionturnos.entity.Turno;
import edu.javeriana.gestionturnos.entity.Docente;
import edu.javeriana.gestionturnos.entity.Zona;
import edu.javeriana.gestionturnos.enums.EstadoTurno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long> {

    List<Turno> findByDocente(Docente docente);

    List<Turno> findByZona(Zona zona);

    List<Turno> findByFecha(LocalDate fecha);

    List<Turno> findByEstado(EstadoTurno estado);

    List<Turno> findByDocenteAndFecha(Docente docente, LocalDate fecha);
}