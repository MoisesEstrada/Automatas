package com.example.Duolingo_free.repository;

import com.example.Duolingo_free.model.Opcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpcionRepository extends JpaRepository<Opcion, Integer> {

    List<Opcion> findByPregunta_IdPregunta(Integer idPregunta);
}
