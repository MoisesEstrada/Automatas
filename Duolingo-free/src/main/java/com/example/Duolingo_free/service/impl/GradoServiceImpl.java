package com.example.Duolingo_free.service.impl;

import com.example.Duolingo_free.model.Grado;
import com.example.Duolingo_free.repository.GradoRepository;
import com.example.Duolingo_free.service.GradoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradoServiceImpl implements GradoService {

    private final GradoRepository gradoRepository;

    public GradoServiceImpl(GradoRepository gradoRepository) {
        this.gradoRepository = gradoRepository;
    }

    @Override
    public Grado guardar(Grado grado) {
        return gradoRepository.save(grado);
    }

    @Override
    public List<Grado> listarTodos() {
        return gradoRepository.findAll();
    }

    @Override
    public Optional<Grado> buscarPorId(Integer id) {
        return gradoRepository.findById(id);
    }
}
