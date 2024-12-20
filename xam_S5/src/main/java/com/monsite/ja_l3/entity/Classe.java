package com.monsite.ja_l3.entity;

import lombok.Data;
import java.util.List;

@Data
public class Classe {
    private int id; 
    private String nom; 
    private Niveau niveau; 
    private List<Etudiant> etudiants; 
    private List<Cours> cours; 

    
    public Classe() {}

    
    public Classe(String nom, Niveau niveau) {
        this.nom = nom;
        this.niveau = niveau;
    }

    
    public Classe(int id, String nom, Niveau niveau, List<Etudiant> etudiants, List<Cours> cours) {
        this.id = id;
        this.nom = nom;
        this.niveau = niveau;
        this.etudiants = etudiants;
        this.cours = cours;
    }

    
}
