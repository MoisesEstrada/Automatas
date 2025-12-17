package com.example.Duolingo_free.service.impl;

import com.example.Duolingo_free.model.Pregunta;
import com.example.Duolingo_free.repository.PreguntaRepository;
import com.example.Duolingo_free.service.PreguntaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PreguntaServiceImpl implements PreguntaService {

    private final PreguntaRepository preguntaRepository;

    public PreguntaServiceImpl(PreguntaRepository preguntaRepository) {
        this.preguntaRepository = preguntaRepository;
    }

    @Override
    public Pregunta guardar(Pregunta pregunta) {
        return preguntaRepository.save(pregunta);
    }

    @Override
    public List<Pregunta> listarPorRonda(Integer idRonda) {
        return preguntaRepository.findByRonda_IdRonda(idRonda);
    }

    @Override
    public void eliminar(Integer id) {
        preguntaRepository.deleteById(id);
    }
}
