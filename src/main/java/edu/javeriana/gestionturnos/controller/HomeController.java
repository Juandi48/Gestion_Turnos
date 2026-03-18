package edu.javeriana.gestionturnos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("titulo", "Sistema de Gestión de Turnos e Incidentes");
        model.addAttribute("universidad", "Pontificia Universidad Javeriana");
        model.addAttribute("modulo", "Inicio");
        return "home/index";
    }
}