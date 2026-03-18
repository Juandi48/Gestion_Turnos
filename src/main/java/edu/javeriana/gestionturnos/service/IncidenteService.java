package edu.javeriana.gestionturnos.service;

import edu.javeriana.gestionturnos.entity.Incidente;

import java.util.List;

public interface IncidenteService {

    List<Incidente> findAll();

    Incidente findById(Long id);

    Incidente save(Incidente incidente);

    void deleteById(Long id);
}