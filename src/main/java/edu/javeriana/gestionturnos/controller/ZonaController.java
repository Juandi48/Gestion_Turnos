package edu.javeriana.gestionturnos.controller;

import edu.javeriana.gestionturnos.entity.Zona;
import edu.javeriana.gestionturnos.service.ZonaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/zonas")
public class ZonaController {

    private final ZonaService zonaService;

    public ZonaController(ZonaService zonaService) {
        this.zonaService = zonaService;
    }

    @GetMapping
    public String listarZonas(Model model) {
        model.addAttribute("titulo", "Listado de Zonas");
        model.addAttribute("zonas", zonaService.findAll());
        return "zonas/list";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("titulo", "Nueva Zona");
        model.addAttribute("zona", new Zona());
        return "zonas/form";
    }

    @PostMapping("/guardar")
    public String guardarZona(@Valid @ModelAttribute("zona") Zona zona,
                              BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Nueva Zona");
            return "zonas/form";
        }

        zonaService.save(zona);
        return "redirect:/zonas";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Zona zona = zonaService.findById(id);
        model.addAttribute("titulo", "Editar Zona");
        model.addAttribute("zona", zona);
        return "zonas/form";
    }

    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable Long id, Model model) {
        Zona zona = zonaService.findById(id);
        model.addAttribute("titulo", "Detalle de la Zona");
        model.addAttribute("zona", zona);
        return "zonas/detail";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarZona(@PathVariable Long id) {
        zonaService.deleteById(id);
        return "redirect:/zonas";
    }
}