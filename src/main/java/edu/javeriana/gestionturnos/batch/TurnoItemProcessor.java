package edu.javeriana.gestionturnos.batch;

import edu.javeriana.gestionturnos.entity.Docente;
import edu.javeriana.gestionturnos.entity.Turno;
import edu.javeriana.gestionturnos.entity.Zona;
import edu.javeriana.gestionturnos.enums.EstadoTurno;
import edu.javeriana.gestionturnos.repository.DocenteRepository;
import edu.javeriana.gestionturnos.repository.ZonaRepository;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class TurnoItemProcessor implements ItemProcessor<TurnoCsvRow, Turno> {

    private final DocenteRepository docenteRepository;
    private final ZonaRepository zonaRepository;

    public TurnoItemProcessor(DocenteRepository docenteRepository, ZonaRepository zonaRepository) {
        this.docenteRepository = docenteRepository;
        this.zonaRepository = zonaRepository;
    }

    @Override
    public Turno process(TurnoCsvRow row) {
        Docente docente = docenteRepository.findByCorreo(row.getCorreoDocente())
                .orElseThrow(() -> new IllegalArgumentException(
                        "No se encontró docente con correo: " + row.getCorreoDocente()
                ));

        Zona zona = zonaRepository.findByNombre(row.getNombreZona())
                .orElseThrow(() -> new IllegalArgumentException(
                        "No se encontró zona con nombre: " + row.getNombreZona()
                ));

        Turno turno = new Turno();
        turno.setFecha(LocalDate.parse(row.getFecha()));
        turno.setHoraInicio(LocalTime.parse(row.getHoraInicio()));
        turno.setHoraFin(LocalTime.parse(row.getHoraFin()));
        turno.setEstado(EstadoTurno.valueOf(row.getEstado().trim().toUpperCase()));
        turno.setDocente(docente);
        turno.setZona(zona);

        return turno;
    }
}