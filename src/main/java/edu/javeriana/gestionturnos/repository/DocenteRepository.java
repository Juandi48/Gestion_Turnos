package edu.javeriana.gestionturnos.repository;

import edu.javeriana.gestionturnos.entity.Docente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface DocenteRepository extends JpaRepository<Docente, Long> {

    Optional<Docente> findByCorreo(String correo);

    List<Docente> findByActivoTrue();

    boolean existsByCorreo(String correo);
}