package com.monappli.monappli.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.monappli.monappli.model.Livre;
import com.monappli.monappli.model.Auteur;
import com.monappli.monappli.repository.LivreRepository;
import com.monappli.monappli.repository.AuteurRepository;

@Service
public class LivreService {
    private final LivreRepository livreRepository;
    private final AuteurRepository auteurRepository;

    public LivreService(LivreRepository livreRepository, AuteurRepository auteurRepository) {
        this.livreRepository = livreRepository;
        this.auteurRepository = auteurRepository;
    }

    public Livre creerLivre(Livre livre) {
        Long auteurId = livre.getAuteur().getId();
        Auteur auteur = auteurRepository.findById(auteurId)
            .orElseThrow(() -> new RuntimeException("Auteur non trouvé avec l'ID : " + auteurId));
        livre.setAuteur(auteur);
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

                    if (livreDetails.getAuteur() != null) {
                        Long auteurId = livreDetails.getAuteur().getId();
                        Auteur auteur = auteurRepository.findById(auteurId)
                            .orElseThrow(() -> new RuntimeException("Auteur non trouvé avec l'ID : " + auteurId));
                        livre.setAuteur(auteur);
                    }

                    return livreRepository.save(livre);
                });
    }

    public void supprimerLivre(Long id) {
        livreRepository.deleteById(id);
    }
}
