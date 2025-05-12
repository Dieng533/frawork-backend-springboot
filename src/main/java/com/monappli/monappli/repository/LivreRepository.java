package com.monappli.monappli.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.monappli.monappli.model.Livre;

import java.util.List;

public interface LivreRepository extends JpaRepository<Livre, Long> {
    List<Livre> findByAuteurId(Long auteurId);
}