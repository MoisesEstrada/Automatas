package com.example.Duolingo_free.service;

import com.example.Duolingo_free.model.Pregunta;

import java.util.List;

public interface PreguntaService {

    Pregunta guardar(Pregunta pregunta);

    List<Pregunta> listarPorRonda(Integer idRonda);

    void eliminar(Integer id);
}
