package com.monappli.monappli.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.monappli.monappli.model.Livre;
import com.monappli.monappli.repository.LivreRepository;

@Service
public class LivreService {
    private final LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }

    public Livre creerLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    public List<Livre> listerLivres() {
        return livreRepository.findAll();
    }

    public List<Livre> listerLivresParAuteur(Long auteurId) {
        return livreRepository.findByAuteurId(auteurId);
    }

    public Optional<Livre> modifierLivre(Long id, Livre livreDetails) {
        return livreRepository.findById(id)
                .map(livre -> {
                    livre.setTitre(livreDetails.getTitre());
                    livre.setIsbn(livreDetails.getIsbn());
                    livre.setAnneePublication(livreDetails.getAnneePublication());
                    return livreRepository.save(livre);
                });
    }

    public void supprimerLivre(Long id) {
        livreRepository.deleteById(id);
    }
}