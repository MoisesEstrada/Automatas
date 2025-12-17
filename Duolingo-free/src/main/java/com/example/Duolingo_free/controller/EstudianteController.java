package com.example.Duolingo_free.controller;

import com.example.Duolingo_free.service.RondaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estudiante")
public class EstudianteController {

    private final RondaService rondaService;

    public EstudianteController(RondaService rondaService) {
        this.rondaService = rondaService;
    }

    @GetMapping
    public String dashboard() {
        return "estudiante/dashboard";
    }

    @GetMapping("/rondas")
    public String verRondas(@RequestParam Integer gradoId, Model model) {
        model.addAttribute("rondas",
                rondaService.listarPorGrado(gradoId));
        return "estudiante/rondas";
    }

    @GetMapping("/quiz/{id}")
    public String iniciarQuiz(@PathVariable Integer id, Model model) {
        model.addAttribute("rondaId", id);
        return "estudiante/quiz";
    }
}
