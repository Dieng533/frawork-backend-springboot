package com.monappli.monappli.service;


import org.springframework.stereotype.Service;

import com.monappli.monappli.model.Auteur;
import com.monappli.monappli.repository.AuteurRepository;

import java.util.List;

@Service
public class AuteurService {
    private final AuteurRepository auteurRepository;

    public AuteurService(AuteurRepository auteurRepository) {
        this.auteurRepository = auteurRepository;
    }

    public Auteur creerAuteur(Auteur auteur) {
        return auteurRepository.save(auteur);
    }

    public List<Auteur> listerAuteurs() {
        return auteurRepository.findAll();
    }
}