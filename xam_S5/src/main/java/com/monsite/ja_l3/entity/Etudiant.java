package com.monsite.ja_l3.entity;

import lombok.Data;

@Data
public class Etudiant {
    private int id;
    private String nom; // Nom de l'étudiant
    private String prenom; // Prénom de l'étudiant
    private Classe classe; // Relation avec Classe



    public Etudiant() {}

    public Etudiant(String nom, String prenom, Classe classe) {
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
    }
    
    public Etudiant(int id, String nom, String prenom, Classe classe) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.classe = classe;
    }
    
}
