package com.monappli.monappli.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.monappli.monappli.model.Livre;
import com.monappli.monappli.service.LivreService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/livres")
public class LivreController {
    private final LivreService livreService;

    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    @PostMapping
    public Livre creerLivre(@RequestBody Livre livre) {
        return livreService.creerLivre(livre);
    }

    @GetMapping
    public List<Livre> listerLivres() {
        return livreService.listerLivres();
    }

    @GetMapping("/auteur/{auteurId}")
    public List<Livre> listerLivresParAuteur(@PathVariable Long auteurId) {
        return livreService.listerLivresParAuteur(auteurId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livre> modifierLivre(@PathVariable Long id, @RequestBody Livre livreDetails) {
        Optional<Livre> livre = livreService.modifierLivre(id, livreDetails);
        return livre.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerLivre(@PathVariable Long id) {
        livreService.supprimerLivre(id);
        return ResponseEntity.noContent().build();
    }
}