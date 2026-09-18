package com.mariapenaranda.carreraacademica.controller;

import com.mariapenaranda.carreraacademica.entity.CarreraAcademica;
import com.mariapenaranda.carreraacademica.service.CarreraAcademicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/carreras")
public class CarreraController {

    @Autowired
    private CarreraAcademicaService carreraService;

    // LISTAR
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("carreras", carreraService.listarTodas());
        return "carrera/listar";
    }

    // MOSTRAR FORMULARIO NUEVA CARRERA
    @GetMapping("/nueva")
    public String mostrarFormularioNueva(Model model) {
        model.addAttribute("carrera", new CarreraAcademica());
        model.addAttribute("titulo", "Nueva Carrera Académica");
        return "carrera/formulario";
    }

    // GUARDAR
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("carrera") CarreraAcademica carrera) {
        carreraService.guardar(carrera);
        return "redirect:/carreras";
    }

    // MOSTRAR FORMULARIO EDITAR
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        CarreraAcademica carrera = carreraService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Carrera no encontrada con id: " + id));
        model.addAttribute("carrera", carrera);
        model.addAttribute("titulo", "Editar Carrera Académica");
        return "carrera/formulario";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        carreraService.eliminar(id);
        return "redirect:/carreras";
    }

    //REPORTES
    @GetMapping("/reportes")
    public String mostrarReportes() {
        return "carrera/reportes";
    }

    @GetMapping("/reporte/universidad-nivel")
    public String reportePorUniversidadYNivel(
            @RequestParam String universidad,
            @RequestParam String nivelFormacion,
            Model model) {

        model.addAttribute("carreras",
                carreraService.buscarPorUniversidadYNivel(universidad, nivelFormacion));
        model.addAttribute("titulo", "Carreras de " + universidad + " - Nivel: " + nivelFormacion);
        return "carrera/listar";
    }

    @GetMapping("/reporte/acreditadas")
    public String reporteAcreditadasPorRango(
            @RequestParam Double min,
            @RequestParam Double max,
            Model model) {

        model.addAttribute("carreras",
                carreraService.buscarAcreditadasPorRangoValor(min, max));
        model.addAttribute("titulo", "Carreras Acreditadas entre $" + min + " y $" + max);
        return "carrera/listar";
    }
}