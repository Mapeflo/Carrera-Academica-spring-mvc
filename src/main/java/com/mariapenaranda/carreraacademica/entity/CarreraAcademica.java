package com.mariapenaranda.carreraacademica.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "carreras_academicas")
public class CarreraAcademica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer numCreditos;
    private Integer numAsignaturas;
    private Integer numSemestres;
    private String nivelFormacion;
    private String titulo;
    private Double valorSemestre;
    private String universidad;
    private Boolean esAcreditada;
    private String perfiles;
    private String areaConocimiento;


    public CarreraAcademica() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getNumCreditos() {
        return numCreditos;
    }

    public void setNumCreditos(Integer numCreditos) {
        this.numCreditos = numCreditos;
    }

    public Integer getNumAsignaturas() {
        return numAsignaturas;
    }

    public void setNumAsignaturas(Integer numAsignaturas) {
        this.numAsignaturas = numAsignaturas;
    }

    public Integer getNumSemestres() {
        return numSemestres;
    }

    public void setNumSemestres(Integer numSemestres) {
        this.numSemestres = numSemestres;
    }

    public String getNivelFormacion() {
        return nivelFormacion;
    }

    public void setNivelFormacion(String nivelFormacion) {
        this.nivelFormacion = nivelFormacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getValorSemestre() {
        return valorSemestre;
    }

    public void setValorSemestre(Double valorSemestre) {
        this.valorSemestre = valorSemestre;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public Boolean getEsAcreditada() {
        return esAcreditada;
    }

    public void setEsAcreditada(Boolean esAcreditada) {
        this.esAcreditada = esAcreditada;
    }

    public String getPerfiles() {
        return perfiles;
    }

    public void setPerfiles(String perfiles) {
        this.perfiles = perfiles;
    }

    public String getAreaConocimiento() {
        return areaConocimiento;
    }

    public void setAreaConocimiento(String areaConocimiento) {
        this.areaConocimiento = areaConocimiento;
    }
}
