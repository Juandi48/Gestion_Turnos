package edu.javeriana.gestionturnos.service;

import edu.javeriana.gestionturnos.entity.Zona;

import java.util.List;

public interface ZonaService {

    List<Zona> findAll();

    Zona findById(Long id);

    Zona save(Zona zona);

    void deleteById(Long id);
}