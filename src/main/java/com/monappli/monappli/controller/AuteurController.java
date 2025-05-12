package com.monappli.monappli.controller;


import org.springframework.web.bind.annotation.*;

import com.monappli.monappli.model.Auteur;
import com.monappli.monappli.service.AuteurService;

import java.util.List;

@RestController
@RequestMapping("/api/auteurs")
public class AuteurController {
    private final AuteurService auteurService;

    public AuteurController(AuteurService auteurService) {
        this.auteurService = auteurService;
    }

    @PostMapping
    public Auteur creerAuteur(@RequestBody Auteur auteur) {
        return auteurService.creerAuteur(auteur);
    }

    @GetMapping
    public List<Auteur> listerAuteurs() {
        return auteurService.listerAuteurs();
    }
}