package com.example.Duolingo_free.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "ronda")
public class Ronda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRonda;

    private String titulo;

    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "id_docente")
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "id_grado")
    private Grado grado;

    private LocalDateTime fechaCreacion = LocalDateTime.now();

    // GETTERS Y SETTERS
    public Integer getIdRonda() {
        return idRonda;
    }

    public void setIdRonda(Integer idRonda) {
        this.idRonda = idRonda;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Grado getGrado() {
        return grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }
}
