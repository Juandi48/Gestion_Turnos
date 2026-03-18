package edu.javeriana.gestionturnos.controller;

import edu.javeriana.gestionturnos.entity.Incidente;
import edu.javeriana.gestionturnos.enums.SeveridadIncidente;
import edu.javeriana.gestionturnos.enums.TipoIncidente;
import edu.javeriana.gestionturnos.service.DocenteService;
import edu.javeriana.gestionturnos.service.IncidenteService;
import edu.javeriana.gestionturnos.service.TurnoService;
import edu.javeriana.gestionturnos.service.ZonaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/incidentes")
public class IncidenteController {

    private final IncidenteService incidenteService;
    private final ZonaService zonaService;
    private final TurnoService turnoService;
    private final DocenteService docenteService;

    public IncidenteController(IncidenteService incidenteService,
                               ZonaService zonaService,
                               TurnoService turnoService,
                               DocenteService docenteService) {
        this.incidenteService = incidenteService;
        this.zonaService = zonaService;
        this.turnoService = turnoService;
        this.docenteService = docenteService;
    }

    @GetMapping
    public String listarIncidentes(Model model) {
        model.addAttribute("titulo", "Listado de Incidentes");
        model.addAttribute("incidentes", incidenteService.findAll());
        return "incidentes/list";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("titulo", "Registrar Incidente");
        model.addAttribute("incidente", new Incidente());
        model.addAttribute("tiposIncidente", TipoIncidente.values());
        model.addAttribute("severidades", SeveridadIncidente.values());
        model.addAttribute("zonas", zonaService.findAll());
        model.addAttribute("turnos", turnoService.findAll());
        model.addAttribute("docentes", docenteService.findAll());
        return "incidentes/form";
    }

    @PostMapping("/guardar")
    public String guardarIncidente(@Valid @ModelAttribute("incidente") Incidente incidente,
                                   BindingResult result,
                                   Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Registrar Incidente");
            model.addAttribute("tiposIncidente", TipoIncidente.values());
            model.addAttribute("severidades", SeveridadIncidente.values());
            model.addAttribute("zonas", zonaService.findAll());
            model.addAttribute("turnos", turnoService.findAll());
            model.addAttribute("docentes", docenteService.findAll());
            return "incidentes/form";
        }

        incidenteService.save(incidente);
        return "redirect:/incidentes";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Incidente incidente = incidenteService.findById(id);
        model.addAttribute("titulo", "Editar Incidente");
        model.addAttribute("incidente", incidente);
        model.addAttribute("tiposIncidente", TipoIncidente.values());
        model.addAttribute("severidades", SeveridadIncidente.values());
        model.addAttribute("zonas", zonaService.findAll());
        model.addAttribute("turnos", turnoService.findAll());
        model.addAttribute("docentes", docenteService.findAll());
        return "incidentes/form";
    }

    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable Long id, Model model) {
        Incidente incidente = incidenteService.findById(id);
        model.addAttribute("titulo", "Detalle del Incidente");
        model.addAttribute("incidente", incidente);
        return "incidentes/detail";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarIncidente(@PathVariable Long id) {
        incidenteService.deleteById(id);
        return "redirect:/incidentes";
    }
}