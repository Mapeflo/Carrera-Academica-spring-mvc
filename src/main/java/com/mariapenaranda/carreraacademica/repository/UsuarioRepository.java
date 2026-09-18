package com.mariapenaranda.carreraacademica.repository;

import com.mariapenaranda.carreraacademica.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNombre(String nombre);

    List<Usuario> findByRol(String rol);

    List<Usuario> findByNombreContainingIgnoreCase(String nombre);
}
