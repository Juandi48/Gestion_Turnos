package edu.javeriana.gestionturnos.controller;

import edu.javeriana.gestionturnos.entity.Reemplazo;
import edu.javeriana.gestionturnos.enums.EstadoReemplazo;
import edu.javeriana.gestionturnos.service.DocenteService;
import edu.javeriana.gestionturnos.service.ReemplazoService;
import edu.javeriana.gestionturnos.service.TurnoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reemplazos")
public class ReemplazoController {

    private final ReemplazoService reemplazoService;
    private final TurnoService turnoService;
    private final DocenteService docenteService;

    public ReemplazoController(ReemplazoService reemplazoService,
                               TurnoService turnoService,
                               DocenteService docenteService) {
        this.reemplazoService = reemplazoService;
        this.turnoService = turnoService;
        this.docenteService = docenteService;
    }

    @GetMapping
    public String listarReemplazos(Model model) {
        model.addAttribute("titulo", "Listado de Reemplazos");
        model.addAttribute("reemplazos", reemplazoService.findAll());
        return "reemplazos/list";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("titulo", "Solicitar Reemplazo");
        model.addAttribute("reemplazo", new Reemplazo());
        model.addAttribute("turnos", turnoService.findAll());
        model.addAttribute("docentes", docenteService.findAll());
        model.addAttribute("estados", EstadoReemplazo.values());
        return "reemplazos/form";
    }

    @PostMapping("/guardar")
    public String guardarReemplazo(@Valid @ModelAttribute("reemplazo") Reemplazo reemplazo,
                                   BindingResult result,
                                   Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Solicitar Reemplazo");
            model.addAttribute("turnos", turnoService.findAll());
            model.addAttribute("docentes", docenteService.findAll());
            model.addAttribute("estados", EstadoReemplazo.values());
            return "reemplazos/form";
        }

        reemplazoService.save(reemplazo);
        return "redirect:/reemplazos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Reemplazo reemplazo = reemplazoService.findById(id);
        model.addAttribute("titulo", "Editar Reemplazo");
        model.addAttribute("reemplazo", reemplazo);
        model.addAttribute("turnos", turnoService.findAll());
        model.addAttribute("docentes", docenteService.findAll());
        model.addAttribute("estados", EstadoReemplazo.values());
        return "reemplazos/form";
    }

    @GetMapping("/sugerencias/{turnoId}")
    public String verSugerencias(@PathVariable Long turnoId, Model model) {
        model.addAttribute("titulo", "Sugerencias de Reemplazo");
        model.addAttribute("turno", turnoService.findById(turnoId));
        model.addAttribute("sugerencias", reemplazoService.obtenerSugerenciasPorTurno(turnoId));
        return "reemplazos/sugerencias";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarReemplazo(@PathVariable Long id) {
        reemplazoService.deleteById(id);
        return "redirect:/reemplazos";
    }
}