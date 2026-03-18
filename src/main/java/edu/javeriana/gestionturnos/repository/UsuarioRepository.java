package edu.javeriana.gestionturnos.repository;

import edu.javeriana.gestionturnos.entity.Usuario;
import edu.javeriana.gestionturnos.entity.Docente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);

    Optional<Usuario> findByDocente(Docente docente);

    boolean existsByUsername(String username);
}