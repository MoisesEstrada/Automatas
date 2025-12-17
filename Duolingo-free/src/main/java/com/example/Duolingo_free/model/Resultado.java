package com.example.Duolingo_free.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "resultado")
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idResultado;

    @ManyToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "id_ronda")
    private Ronda ronda;

    private Integer puntaje;

    private LocalDateTime fecha = LocalDateTime.now();

    // GETTERS Y SETTERS
}
