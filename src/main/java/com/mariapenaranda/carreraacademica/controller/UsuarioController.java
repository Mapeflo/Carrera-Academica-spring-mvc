package com.mariapenaranda.carreraacademica.controller;

import com.mariapenaranda.carreraacademica.entity.Usuario;
import com.mariapenaranda.carreraacademica.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // LISTAR
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioService.listarTodos());
        return "usuario/listar";
    }

    // MOSTRAR FORMULARIO NUEVO
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("titulo", "Nuevo Usuario");
        return "usuario/formulario";
    }

    // GUARDAR
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute("usuario") Usuario usuario) {
        usuarioService.guardar(usuario);
        return "redirect:/usuarios";
    }

    // MOSTRAR FORMULARIO EDITAR
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.buscarPorId(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con id: " + id));
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Editar Usuario");
        return "usuario/formulario";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return "redirect:/usuarios";
    }
    //REPORTES
    @GetMapping("/reportes")
    public String mostrarReportes() {
        return "usuario/reportes";
    }

    @GetMapping("/reporte/rol")
    public String reportePorRol(@RequestParam String rol, Model model) {
        model.addAttribute("usuarios", usuarioService.buscarPorRol(rol));
        model.addAttribute("titulo", "Usuarios con rol: " + rol);
        return "usuario/listar";
    }

    @GetMapping("/reporte/nombre")
    public String reportePorNombre(@RequestParam String nombre, Model model) {
        model.addAttribute("usuarios", usuarioService.buscarPorNombreParcial(nombre));
        model.addAttribute("titulo", "Usuarios que contienen: " + nombre);
        return "usuario/listar";
    }
}