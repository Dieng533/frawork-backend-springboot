package com.monappli.monappli.model;


import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Auteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nom;
    private String prenom;
    
    @OneToMany(mappedBy = "auteur", cascade = CascadeType.ALL)
    private List<Livre> livres;
}