package com.example.Duolingo_free.service;

import com.example.Duolingo_free.model.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteService {

    Estudiante guardar(Estudiante estudiante);

    List<Estudiante> listarTodos();

    List<Estudiante> listarPorGrado(Integer idGrado);

    Optional<Estudiante> buscarPorId(Integer id);

    void eliminar(Integer id);
}
