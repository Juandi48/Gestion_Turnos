package edu.javeriana.gestionturnos.repository;

import edu.javeriana.gestionturnos.entity.Incidente;
import edu.javeriana.gestionturnos.entity.Zona;
import edu.javeriana.gestionturnos.enums.SeveridadIncidente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidenteRepository extends JpaRepository<Incidente, Long> {

    List<Incidente> findByZona(Zona zona);

    List<Incidente> findBySeveridad(SeveridadIncidente severidad);

    List<Incidente> findByZonaAndSeveridad(Zona zona, SeveridadIncidente severidad);
}