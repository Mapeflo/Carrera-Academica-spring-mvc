package com.mariapenaranda.carreraacademica.repository;

import com.mariapenaranda.carreraacademica.entity.CarreraAcademica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarreraAcademicaRepository extends JpaRepository<CarreraAcademica, Long> {

    // Consultas parametrizadas (reportes)
    List<CarreraAcademica> findByUniversidadContainingIgnoreCase(String universidad);

    List<CarreraAcademica> findByNivelFormacion(String nivelFormacion);

    List<CarreraAcademica> findByEsAcreditada(Boolean esAcreditada);

    List<CarreraAcademica> findByAreaConocimientoContainingIgnoreCase(String area);

    List<CarreraAcademica> findByUniversidadAndNivelFormacion(String universidad, String nivelFormacion);

    List<CarreraAcademica> findByEsAcreditadaTrueAndValorSemestreBetween(Double min, Double max);
}