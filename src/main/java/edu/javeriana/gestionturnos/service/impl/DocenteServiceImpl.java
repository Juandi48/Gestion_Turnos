package edu.javeriana.gestionturnos.service.impl;

import edu.javeriana.gestionturnos.entity.Docente;
import edu.javeriana.gestionturnos.exception.ResourceNotFoundException;
import edu.javeriana.gestionturnos.repository.DocenteRepository;
import edu.javeriana.gestionturnos.service.DocenteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteServiceImpl implements DocenteService {

    private final DocenteRepository docenteRepository;

    public DocenteServiceImpl(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    @Override
    public List<Docente> findAll() {
        return docenteRepository.findAll();
    }

    @Override
    public Docente findById(Long id) {
        return docenteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el docente con id: " + id));
    }

    @Override
    public Docente save(Docente docente) {
        return docenteRepository.save(docente);
    }

    @Override
    public void deleteById(Long id) {
        if (!docenteRepository.existsById(id)) {
            throw new ResourceNotFoundException("No se puede eliminar. No existe el docente con id: " + id);
        }
        docenteRepository.deleteById(id);
    }
}