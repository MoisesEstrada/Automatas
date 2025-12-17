package com.example.Duolingo_free.model;

import jakarta.persistence.*;

@Entity
@Table(name = "progreso")
public class Progreso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProgreso;

    @OneToOne
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    private Integer totalRondas = 0;
    private Integer rondasCompletadas = 0;

    // GETTERS Y SETTERS
}
