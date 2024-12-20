package com.monsite.ja_l3.entity;

import lombok.Data;

@Data
public class Niveau {
    private int id;       
    private String nom;   // Nom du niveau (ex : L1, L2, L3)

   
    public Niveau() {}

    public Niveau(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }
}
