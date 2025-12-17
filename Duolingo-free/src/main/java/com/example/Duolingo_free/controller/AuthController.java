package com.example.Duolingo_free.controller;

import com.example.Duolingo_free.model.Usuario;
import com.example.Duolingo_free.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String procesarLogin(@RequestParam String email,
                                @RequestParam String password,
                                Model model) {

        return usuarioService.buscarPorEmail(email)
                .filter(u -> u.getPassword().equals(password))
                .map(u -> {
                    switch (u.getRol()) {
                        case ADMIN -> {
                            return "redirect:/admin";
                        }
                        case DOCENTE -> {
                            return "redirect:/docente";
                        }
                        case ESTUDIANTE -> {
                            return "redirect:/estudiante";
                        }
                        default -> {
                            return "redirect:/login";
                        }
                    }
                })
                .orElseGet(() -> {
                    model.addAttribute("error", "Credenciales incorrectas");
                    return "login";
                });
    }
}
