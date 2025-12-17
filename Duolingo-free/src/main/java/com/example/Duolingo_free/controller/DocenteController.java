package com.example.Duolingo_free.controller;

import com.example.Duolingo_free.model.Docente;
import com.example.Duolingo_free.model.Ronda;
import com.example.Duolingo_free.service.RondaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/docente")
public class DocenteController {

    private final RondaService rondaService;

    public DocenteController(RondaService rondaService) {
        this.rondaService = rondaService;
    }

    @GetMapping
    public String dashboard() {
        return "docente/dashboard";
    }

    @GetMapping("/ronda")
    public String listarRondas(@RequestParam Integer docenteId, Model model) {
        model.addAttribute("ronda",
                rondaService.listarPorDocente(docenteId));
        return "docente/rondas";   // ✅ CORRECTO
    }


    @GetMapping("/ronda/nueva")
    public String nuevaRonda(@RequestParam Integer docenteId, Model model) {
        model.addAttribute("ronda", new Ronda());
        model.addAttribute("docenteId", docenteId);
        return "docente/crear-ronda";
    }

    @PostMapping("/ronda/guardar")
    public String guardarRonda(@ModelAttribute Ronda ronda,
                               @RequestParam Integer docenteId) {

        Docente docente = new Docente();
        docente.setIdDocente(docenteId);
        ronda.setDocente(docente);

        rondaService.guardar(ronda);
        return "redirect:/docente/rondas?docenteId=" + docenteId;
    }
}

