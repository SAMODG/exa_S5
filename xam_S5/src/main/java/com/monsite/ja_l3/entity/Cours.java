package com.monsite.ja_l3.entity;
import lombok.Data;
import java.util.List;

@Data
public class Cours {
    private int id;
    private String module;
    private Professeur professeur; // Relation avec Professeur
    private List<Classe> classes; 
    private List<Session> sessions; 

    public Cours() {}

    public Cours(String module, Professeur professeur, List<Classe> classes, List<Session> sessions) {
        this.module = module;
        this.professeur = professeur;
        this.classes = classes;
        this.sessions = sessions;
    }

    // Constructeur par creerCours
    public Cours(Professeur professeur, String module, List<Classe> classes) {
        this.professeur = professeur;
        this.module = module;
        this.classes = classes;
    }
}



