package edu.javeriana.gestionturnos.service;

import edu.javeriana.gestionturnos.entity.Notificacion;

import java.util.List;

public interface NotificacionService {

    List<Notificacion> findAll();

    Notificacion findById(Long id);

    Notificacion save(Notificacion notificacion);

    void deleteById(Long id);
}