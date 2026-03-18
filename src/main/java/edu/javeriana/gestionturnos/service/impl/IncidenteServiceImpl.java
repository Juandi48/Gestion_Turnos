package edu.javeriana.gestionturnos.service.impl;

import edu.javeriana.gestionturnos.entity.Incidente;
import edu.javeriana.gestionturnos.exception.ResourceNotFoundException;
import edu.javeriana.gestionturnos.repository.IncidenteRepository;
import edu.javeriana.gestionturnos.service.IncidenteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidenteServiceImpl implements IncidenteService {

    private final IncidenteRepository incidenteRepository;

    public IncidenteServiceImpl(IncidenteRepository incidenteRepository) {
        this.incidenteRepository = incidenteRepository;
    }

    @Override
    public List<Incidente> findAll() {
        return incidenteRepository.findAll();
    }

    @Override
    public Incidente findById(Long id) {
        return incidenteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el incidente con id: " + id));
    }

    @Override
    public Incidente save(Incidente incidente) {
        return incidenteRepository.save(incidente);
    }

    @Override
    public void deleteById(Long id) {
        if (!incidenteRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se puede eliminar. No existe el incidente con id: " + id);
        }
        incidenteRepository.deleteById(id);
    }
}