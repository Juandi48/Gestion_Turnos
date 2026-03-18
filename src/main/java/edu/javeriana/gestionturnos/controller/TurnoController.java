package edu.javeriana.gestionturnos.controller;

import edu.javeriana.gestionturnos.entity.Turno;
import edu.javeriana.gestionturnos.service.DocenteService;
import edu.javeriana.gestionturnos.service.TurnoService;
import edu.javeriana.gestionturnos.service.ZonaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/turnos")
public class TurnoController {

    private final TurnoService turnoService;
    private final DocenteService docenteService;
    private final ZonaService zonaService;

    public TurnoController(TurnoService turnoService,
                           DocenteService docenteService,
                           ZonaService zonaService) {
        this.turnoService = turnoService;
        this.docenteService = docenteService;
        this.zonaService = zonaService;
    }

    @GetMapping
    public String listarTurnos(Model model) {
        model.addAttribute("titulo", "Listado de Turnos");
        model.addAttribute("turnos", turnoService.findAll());
        return "turnos/list";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("titulo", "Nuevo Turno");
        model.addAttribute("turno", new Turno());
        model.addAttribute("docentes", docenteService.findAll());
        model.addAttribute("zonas", zonaService.findAll());
        return "turnos/form";
    }

    @PostMapping("/guardar")
    public String guardarTurno(@Valid @ModelAttribute("turno") Turno turno,
                               BindingResult result,
                               Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Nuevo Turno");
            model.addAttribute("docentes", docenteService.findAll());
            model.addAttribute("zonas", zonaService.findAll());
            return "turnos/form";
        }

        turnoService.save(turno);
        return "redirect:/turnos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Turno turno = turnoService.findById(id);
        model.addAttribute("titulo", "Editar Turno");
        model.addAttribute("turno", turno);
        model.addAttribute("docentes", docenteService.findAll());
        model.addAttribute("zonas", zonaService.findAll());
        return "turnos/form";
    }

    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable Long id, Model model) {
        Turno turno = turnoService.findById(id);
        model.addAttribute("titulo", "Detalle del Turno");
        model.addAttribute("turno", turno);
        return "turnos/detail";
    }

    @GetMapping("/calendario")
    public String verCalendario(Model model) {
        model.addAttribute("titulo", "Calendario de Turnos");
        model.addAttribute("turnos", turnoService.findAll());
        return "turnos/calendario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarTurno(@PathVariable Long id) {
        turnoService.deleteById(id);
        return "redirect:/turnos";
    }
}