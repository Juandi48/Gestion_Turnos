package edu.javeriana.gestionturnos.repository;

import edu.javeriana.gestionturnos.entity.Reemplazo;
import edu.javeriana.gestionturnos.entity.Docente;
import edu.javeriana.gestionturnos.entity.Turno;
import edu.javeriana.gestionturnos.enums.EstadoReemplazo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReemplazoRepository extends JpaRepository<Reemplazo, Long> {

    List<Reemplazo> findByTurnoOriginal(Turno turno);

    List<Reemplazo> findByDocenteOriginal(Docente docente);

    List<Reemplazo> findByDocenteReemplazo(Docente docente);

    List<Reemplazo> findByEstado(EstadoReemplazo estado);
}