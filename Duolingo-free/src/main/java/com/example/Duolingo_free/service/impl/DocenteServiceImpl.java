package com.example.Duolingo_free.service.impl;

import com.example.Duolingo_free.model.Docente;
import com.example.Duolingo_free.repository.DocenteRepository;
import com.example.Duolingo_free.service.DocenteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteServiceImpl implements DocenteService {

    private final DocenteRepository docenteRepository;

    public DocenteServiceImpl(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    @Override
    public Docente guardar(Docente docente) {
        return docenteRepository.save(docente);
    }

    @Override
    public List<Docente> listarTodos() {
        return docenteRepository.findAll();
    }

    @Override
    public Optional<Docente> buscarPorId(Integer id) {
        return docenteRepository.findById(id);
    }

    @Override
    public void eliminar(Integer id) {
        docenteRepository.deleteById(id);
    }
}
