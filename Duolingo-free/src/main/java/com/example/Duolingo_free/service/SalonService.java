package com.example.Duolingo_free.service;

import com.example.Duolingo_free.model.Salon;

import java.util.List;
import java.util.Optional;

public interface SalonService {

    Salon guardar(Salon salon);

    List<Salon> listarTodos();

    Optional<Salon> buscarPorId(Integer id);

    void eliminar(Integer id);
}
