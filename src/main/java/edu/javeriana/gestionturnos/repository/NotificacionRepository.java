package edu.javeriana.gestionturnos.repository;

import edu.javeriana.gestionturnos.entity.Notificacion;
import edu.javeriana.gestionturnos.entity.Turno;
import edu.javeriana.gestionturnos.entity.Zona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificacionRepository extends JpaRepository<Notificacion, Long> {

    List<Notificacion> findByTurno(Turno turno);

    List<Notificacion> findByZona(Zona zona);
}