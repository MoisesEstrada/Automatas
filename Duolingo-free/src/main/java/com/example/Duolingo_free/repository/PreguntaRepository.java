package com.example.Duolingo_free.repository;

import com.example.Duolingo_free.model.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PreguntaRepository extends JpaRepository<Pregunta, Integer> {

    List<Pregunta> findByRonda_IdRonda(Integer idRonda);
}
