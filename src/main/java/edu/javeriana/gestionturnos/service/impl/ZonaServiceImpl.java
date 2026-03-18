package edu.javeriana.gestionturnos.service.impl;

import edu.javeriana.gestionturnos.entity.Zona;
import edu.javeriana.gestionturnos.exception.ResourceNotFoundException;
import edu.javeriana.gestionturnos.repository.ZonaRepository;
import edu.javeriana.gestionturnos.service.ZonaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZonaServiceImpl implements ZonaService {

    private final ZonaRepository zonaRepository;

    public ZonaServiceImpl(ZonaRepository zonaRepository) {
        this.zonaRepository = zonaRepository;
    }

    @Override
    public List<Zona> findAll() {
        return zonaRepository.findAll();
    }

    @Override
    public Zona findById(Long id) {
        return zonaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró la zona con id: " + id));
    }

    @Override
    public Zona save(Zona zona) {
        return zonaRepository.save(zona);
    }

    @Override
    public void deleteById(Long id) {
        if (!zonaRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se puede eliminar. No existe la zona con id: " + id);
        }
        zonaRepository.deleteById(id);
    }
}