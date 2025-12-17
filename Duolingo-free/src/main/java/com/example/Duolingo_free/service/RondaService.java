package com.example.Duolingo_free.service;

import com.example.Duolingo_free.model.Ronda;

import java.util.List;
import java.util.Optional;

public interface RondaService {

    Ronda guardar(Ronda ronda);

    List<Ronda> listarPorGrado(Integer idGrado);

    List<Ronda> listarPorDocente(Integer idDocente);

    Optional<Ronda> buscarPorId(Integer id);

    void eliminar(Integer id);
}
