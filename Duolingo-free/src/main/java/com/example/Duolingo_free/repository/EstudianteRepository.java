package com.example.Duolingo_free.repository;

import com.example.Duolingo_free.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

    List<Estudiante> findByGrado_IdGrado(Integer idGrado);
}
