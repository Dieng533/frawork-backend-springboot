package com.monappli.monappli.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.monappli.monappli.model.Auteur;

public interface AuteurRepository extends JpaRepository<Auteur, Long> {
}