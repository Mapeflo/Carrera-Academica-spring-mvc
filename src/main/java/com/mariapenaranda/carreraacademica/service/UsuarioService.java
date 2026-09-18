package com.mariapenaranda.carreraacademica.service;

import com.mariapenaranda.carreraacademica.entity.Usuario;
import com.mariapenaranda.carreraacademica.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    private PasswordEncoder passwordEncoder;

    public Usuario guardar(Usuario usuario) {

        if (usuario.getClave() != null && !usuario.getClave().isBlank()) {

            if (!usuario.getClave().startsWith("$2a$")) {
                usuario.setClave(passwordEncoder.encode(usuario.getClave()));
            }
        }
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> buscarPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }
}