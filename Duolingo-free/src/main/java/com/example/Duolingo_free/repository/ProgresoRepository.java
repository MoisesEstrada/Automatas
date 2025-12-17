package com.example.Duolingo_free.repository;

import com.example.Duolingo_free.model.Progreso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProgresoRepository extends JpaRepository<Progreso, Integer> {

    Optional<Progreso> findByEstudiante_IdEstudiante(Integer idEstudiante);
}
