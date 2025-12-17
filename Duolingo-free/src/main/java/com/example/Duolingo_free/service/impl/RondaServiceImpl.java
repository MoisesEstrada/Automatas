package com.example.Duolingo_free.service.impl;

import com.example.Duolingo_free.model.Ronda;
import com.example.Duolingo_free.repository.RondaRepository;
import com.example.Duolingo_free.service.RondaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RondaServiceImpl implements RondaService {

    private final RondaRepository rondaRepository;

    public RondaServiceImpl(RondaRepository rondaRepository) {
        this.rondaRepository = rondaRepository;
    }

    @Override
    public Ronda guardar(Ronda ronda) {
        return rondaRepository.save(ronda);
    }

    @Override
    public List<Ronda> listarPorGrado(Integer idGrado) {
        return rondaRepository.findByGrado_IdGrado(idGrado);
    }

    @Override
    public List<Ronda> listarPorDocente(Integer idDocente) {
        return rondaRepository.findByDocente_IdDocente(idDocente);
    }

    @Override
    public Optional<Ronda> buscarPorId(Integer id) {
        return rondaRepository.findById(id);
    }

    @Override
    public void eliminar(Integer id) {
        rondaRepository.deleteById(id);
    }
}
