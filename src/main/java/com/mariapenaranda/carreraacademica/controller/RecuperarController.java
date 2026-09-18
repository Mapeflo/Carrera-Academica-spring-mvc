package com.mariapenaranda.carreraacademica.controller;

import com.mariapenaranda.carreraacademica.entity.Usuario;
import com.mariapenaranda.carreraacademica.service.EmailService;
import com.mariapenaranda.carreraacademica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RecuperarController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/recuperar")
    public String mostrarFormulario() {
        return "recuperar";
    }

    @PostMapping("/recuperar")
    public String procesarRecuperacion(@RequestParam String email, Model model) {

        Usuario usuario = usuarioService.buscarPorEmail(email);

        if (usuario != null) {
            emailService.enviarClave(usuario.getEmail(), usuario.getNombre(), usuario.getClave());
            model.addAttribute("mensaje", "La clave ha sido enviada a tu correo.");
        } else {
            model.addAttribute("error", "No se encontró un usuario con ese correo.");
        }
        return "recuperar";
    }
}