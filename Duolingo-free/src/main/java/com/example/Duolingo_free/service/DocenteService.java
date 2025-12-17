package com.example.Duolingo_free.service;

import com.example.Duolingo_free.model.Docente;

import java.util.List;
import java.util.Optional;

public interface DocenteService {

    Docente guardar(Docente docente);

    List<Docente> listarTodos();

    Optional<Docente> buscarPorId(Integer id);

    void eliminar(Integer id);
}
