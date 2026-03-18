package edu.javeriana.gestionturnos.batch;

import edu.javeriana.gestionturnos.entity.Docente;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class DocenteItemProcessor implements ItemProcessor<Docente, Docente> {

    @Override
    public Docente process(Docente docente) {
        if (docente.getNombre() != null) {
            docente.setNombre(docente.getNombre().trim());
        }

        if (docente.getApellido() != null) {
            docente.setApellido(docente.getApellido().trim());
        }

        if (docente.getCorreo() != null) {
            docente.setCorreo(docente.getCorreo().trim().toLowerCase());
        }

        if (docente.getCargaTurnos() == null) {
            docente.setCargaTurnos(0);
        }

        if (docente.getActivo() == null) {
            docente.setActivo(true);
        }

        return docente;
    }
}