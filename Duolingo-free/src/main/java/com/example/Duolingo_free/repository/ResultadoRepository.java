package com.example.Duolingo_free.repository;

import com.example.Duolingo_free.model.Resultado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultadoRepository extends JpaRepository<Resultado, Integer> {

    List<Resultado> findByEstudiante_IdEstudiante(Integer idEstudiante);
}
