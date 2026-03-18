package edu.javeriana.gestionturnos.service;

import edu.javeriana.gestionturnos.entity.Docente;

import java.util.List;

public interface DocenteService {

    List<Docente> findAll();

    Docente findById(Long id);

    Docente save(Docente docente);

    void deleteById(Long id);
}