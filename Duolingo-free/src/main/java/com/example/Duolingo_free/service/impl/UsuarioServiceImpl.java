package com.example.Duolingo_free.service.impl;

import com.example.Duolingo_free.model.Docente;
import com.example.Duolingo_free.model.Estudiante;
import com.example.Duolingo_free.model.Rol;
import com.example.Duolingo_free.model.Usuario;
import com.example.Duolingo_free.repository.*;
import com.example.Duolingo_free.service.UsuarioService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final DocenteRepository docenteRepository;
    private final EstudianteRepository estudianteRepository;
    private final GradoRepository gradoRepository;
    private final SalonRepository salonRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(
            UsuarioRepository usuarioRepository,
            DocenteRepository docenteRepository,
            EstudianteRepository estudianteRepository,
            GradoRepository gradoRepository,
            SalonRepository salonRepository,
            PasswordEncoder passwordEncoder) {

        this.usuarioRepository = usuarioRepository;
        this.docenteRepository = docenteRepository;
        this.estudianteRepository = estudianteRepository;
        this.gradoRepository = gradoRepository;
        this.salonRepository = salonRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public Usuario guardar(Usuario usuario) {

        // 🔐 CIFRAR PASSWORD (ESTO YA ESTÁ BIEN)
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));

        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        // 👨‍🏫 DOCENTE
        if (usuario.getRol() == Rol.DOCENTE) {
            Docente docente = new Docente();
            docente.setUsuario(usuarioGuardado);
            docenteRepository.save(docente);
        }

        // 🎓 ESTUDIANTE
        if (usuario.getRol() == Rol.ESTUDIANTE) {
            Estudiante estudiante = new Estudiante();
            estudiante.setUsuario(usuarioGuardado);

            // ⚠️ ASIGNACIÓN OBLIGATORIA
            estudiante.setGrado(
                    gradoRepository.findById(1)
                            .orElseThrow(() -> new RuntimeException("Grado no encontrado"))
            );

            estudiante.setSalon(
                    salonRepository.findById(1)
                            .orElseThrow(() -> new RuntimeException("Salón no encontrado"))
            );

            estudianteRepository.save(estudiante);
        }

        return usuarioGuardado;
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> buscarPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public void eliminar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
