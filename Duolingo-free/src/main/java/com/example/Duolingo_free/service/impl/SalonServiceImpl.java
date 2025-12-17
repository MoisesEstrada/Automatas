package com.example.Duolingo_free.service.impl;

import com.example.Duolingo_free.model.Salon;
import com.example.Duolingo_free.repository.SalonRepository;
import com.example.Duolingo_free.service.SalonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalonServiceImpl implements SalonService {

    private final SalonRepository salonRepository;

    public SalonServiceImpl(SalonRepository salonRepository) {
        this.salonRepository = salonRepository;
    }

    @Override
    public Salon guardar(Salon salon) {
        return salonRepository.save(salon);
    }

    @Override
    public List<Salon> listarTodos() {
        return salonRepository.findAll();
    }

    @Override
    public Optional<Salon> buscarPorId(Integer id) {
        return salonRepository.findById(id);
    }

    @Override
    public void eliminar(Integer id) {
        salonRepository.deleteById(id);
    }
}
