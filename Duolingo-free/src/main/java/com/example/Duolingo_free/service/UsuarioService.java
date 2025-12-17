package com.example.Duolingo_free.service;

import com.example.Duolingo_free.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    Usuario guardar(Usuario usuario);

    List<Usuario> listarTodos();

    Optional<Usuario> buscarPorId(Integer id);

    Optional<Usuario> buscarPorEmail(String email);

    void eliminar(Integer id);
}
