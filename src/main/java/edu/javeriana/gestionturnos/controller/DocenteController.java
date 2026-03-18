package edu.javeriana.gestionturnos.controller;

import edu.javeriana.gestionturnos.entity.Docente;
import edu.javeriana.gestionturnos.service.DocenteService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/docentes")
public class DocenteController {

    private final DocenteService docenteService;

    public DocenteController(DocenteService docenteService) {
        this.docenteService = docenteService;
    }

    @GetMapping
    public String listarDocentes(Model model) {
        model.addAttribute("titulo", "Listado de Docentes");
        model.addAttribute("docentes", docenteService.findAll());
        return "docentes/list";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("titulo", "Nuevo Docente");
        model.addAttribute("docente", new Docente());
        return "docentes/form";
    }

    @PostMapping("/guardar")
    public String guardarDocente(@Valid @ModelAttribute("docente") Docente docente,
                                 BindingResult result,
                                 Model model) {
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Nuevo Docente");
            return "docentes/form";
        }

        docenteService.save(docente);
        return "redirect:/docentes";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Docente docente = docenteService.findById(id);
        model.addAttribute("titulo", "Editar Docente");
        model.addAttribute("docente", docente);
        return "docentes/form";
    }

    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable Long id, Model model) {
        Docente docente = docenteService.findById(id);
        model.addAttribute("titulo", "Detalle del Docente");
        model.addAttribute("docente", docente);
        return "docentes/detail";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarDocente(@PathVariable Long id) {
        docenteService.deleteById(id);
        return "redirect:/docentes";
    }
}