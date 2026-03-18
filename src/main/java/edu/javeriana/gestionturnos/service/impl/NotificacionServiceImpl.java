package edu.javeriana.gestionturnos.service.impl;

import edu.javeriana.gestionturnos.entity.Notificacion;
import edu.javeriana.gestionturnos.exception.ResourceNotFoundException;
import edu.javeriana.gestionturnos.repository.NotificacionRepository;
import edu.javeriana.gestionturnos.service.NotificacionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificacionServiceImpl implements NotificacionService {

    private final NotificacionRepository notificacionRepository;

    public NotificacionServiceImpl(NotificacionRepository notificacionRepository) {
        this.notificacionRepository = notificacionRepository;
    }

    @Override
    public List<Notificacion> findAll() {
        return notificacionRepository.findAll();
    }

    @Override
    public Notificacion findById(Long id) {
        return notificacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró la notificación con id: " + id));
    }

    @Override
    public Notificacion save(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    @Override
    public void deleteById(Long id) {
        if (!notificacionRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se puede eliminar. No existe la notificación con id: " + id);
        }
        notificacionRepository.deleteById(id);
    }
}