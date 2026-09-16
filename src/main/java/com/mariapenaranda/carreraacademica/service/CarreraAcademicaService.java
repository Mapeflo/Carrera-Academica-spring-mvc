package com.mariapenaranda.carreraacademica.service;

import com.mariapenaranda.carreraacademica.entity.CarreraAcademica;
import com.mariapenaranda.carreraacademica.repository.CarreraAcademicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarreraAcademicaService {

    @Autowired
    private CarreraAcademicaRepository carreraRepository;

    public List<CarreraAcademica> listarTodas() {
        return carreraRepository.findAll();
    }

    public CarreraAcademica guardar(CarreraAcademica carrera) {
        return carreraRepository.save(carrera);
    }

    public Optional<CarreraAcademica> buscarPorId(Long id) {
        return carreraRepository.findById(id);
    }

    public void eliminar(Long id) {
        carreraRepository.deleteById(id);
    }

    // Métodos para reportes parametrizados
    public List<CarreraAcademica> buscarPorUniversidad(String universidad) {
        return carreraRepository.findByUniversidadContainingIgnoreCase(universidad);
    }

    public List<CarreraAcademica> buscarPorNivelFormacion(String nivel) {
        return carreraRepository.findByNivelFormacion(nivel);
    }

    public List<CarreraAcademica> buscarPorAcreditacion(Boolean acreditada) {
        return carreraRepository.findByEsAcreditada(acreditada);
    }

    public List<CarreraAcademica> buscarPorArea(String area) {
        return carreraRepository.findByAreaConocimientoContainingIgnoreCase(area);
    }
}