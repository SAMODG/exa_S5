package com.monsite.ja_l3.entity;
import lombok.Data;
import java.util.List;

@Data
public class Professeur {
    private int id;
    private String nom; 
    private String specialite; 
    private List<Cours> cours; 



    public Professeur() {}

    public Professeur(String nom, String specialite, List<Cours> cours) {
        this.nom = nom;
        this.specialite = specialite;
        this.cours = cours;
    }
    
    public Professeur(int id, String nom, String specialite, List<Cours> cours) {
        this.id = id;
        this.nom = nom;
        this.specialite = specialite;
        this.cours = cours;
    }
    
}
