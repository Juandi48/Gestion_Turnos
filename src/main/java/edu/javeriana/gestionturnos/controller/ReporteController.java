package edu.javeriana.gestionturnos.controller;

import edu.javeriana.gestionturnos.service.ReporteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reportes")
public class ReporteController {

    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping("/dashboard")
    public String verDashboard(Model model) {
        model.addAttribute("titulo", "Dashboard de Reportes");
        model.addAttribute("incidentesPorZona", reporteService.obtenerIncidentesPorZona());
        model.addAttribute("turnosPorEstado", reporteService.obtenerTurnosPorEstado());
        model.addAttribute("reemplazosPorEstado", reporteService.obtenerReemplazosPorEstado());
        return "reportes/dashboard";
    }

    @GetMapping("/heatmap")
    public String verHeatmap(Model model) {
        model.addAttribute("titulo", "Mapa de Calor por Zona");
        model.addAttribute("heatmapZonas", reporteService.obtenerPorcentajeIncidentesPorZona());
        return "reportes/heatmap-table";
    }
}