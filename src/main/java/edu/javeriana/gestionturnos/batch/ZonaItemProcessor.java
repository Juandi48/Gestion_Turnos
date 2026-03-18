package edu.javeriana.gestionturnos.batch;

import edu.javeriana.gestionturnos.entity.Zona;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class ZonaItemProcessor implements ItemProcessor<Zona, Zona> {

    @Override
    public Zona process(Zona zona) {
        if (zona.getNombre() != null) {
            zona.setNombre(zona.getNombre().trim());
        }

        if (zona.getDescripcion() != null) {
            zona.setDescripcion(zona.getDescripcion().trim());
        }

        if (zona.getBloque() != null) {
            zona.setBloque(zona.getBloque().trim());
        }

        if (zona.getActiva() == null) {
            zona.setActiva(true);
        }

        return zona;
    }
}