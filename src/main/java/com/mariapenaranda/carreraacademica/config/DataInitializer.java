package com.mariapenaranda.carreraacademica.config;

import com.mariapenaranda.carreraacademica.entity.Usuario;
import com.mariapenaranda.carreraacademica.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        // Solo crea el admin si no existe
        if (usuarioRepository.findByNombre("admin").isEmpty()) {
            Usuario admin = new Usuario();
            admin.setNombre("admin");
            admin.setClave(passwordEncoder.encode("admin123"));
            admin.setRol("ADMIN");
            usuarioRepository.save(admin);
            System.out.println(">>> Usuario admin creado (usuario: admin / clave: admin123)");
        }

        // Usuario normal de prueba (opcional)
        if (usuarioRepository.findByNombre("usuario").isEmpty()) {
            Usuario user = new Usuario();
            user.setNombre("usuario");
            user.setClave(passwordEncoder.encode("usuario123"));
            user.setRol("USER");
            usuarioRepository.save(user);
            System.out.println(">>> Usuario normal creado (usuario: usuario / clave: usuario123)");
        }
    }
}