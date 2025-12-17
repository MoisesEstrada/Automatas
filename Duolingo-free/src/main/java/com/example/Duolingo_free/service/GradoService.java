package com.example.Duolingo_free.service;

import com.example.Duolingo_free.model.Grado;

import java.util.List;
import java.util.Optional;

public interface GradoService {

    Grado guardar(Grado grado);

    List<Grado> listarTodos();

    Optional<Grado> buscarPorId(Integer id);
}
