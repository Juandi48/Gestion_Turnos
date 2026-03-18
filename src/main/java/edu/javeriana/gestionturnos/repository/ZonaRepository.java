package edu.javeriana.gestionturnos.repository;

import edu.javeriana.gestionturnos.entity.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ZonaRepository extends JpaRepository<Zona, Long> {

    Optional<Zona> findByNombre(String nombre);

    List<Zona> findByActivaTrue();

    boolean existsByNombre(String nombre);
}