package com.example.Duolingo_free.repository;

import com.example.Duolingo_free.model.Ronda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RondaRepository extends JpaRepository<Ronda, Integer> {

    List<Ronda> findByGrado_IdGrado(Integer idGrado);

    List<Ronda> findByDocente_IdDocente(Integer idDocente);
}
