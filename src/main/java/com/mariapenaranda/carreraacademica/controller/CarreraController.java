package com.mariapenaranda.carreraacademica.controller;

import com.mariapenaranda.carreraacademica.entity.CarreraAcademica;
import com.mariapenaranda.carreraacademica.service.CarreraAcademicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/carreras")
public class CarreraController {

    @Autowired
    private CarreraAcademicaService carreraService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("carreras", carreraService.listarTodas());
        return "carrera/listar";
    }
}