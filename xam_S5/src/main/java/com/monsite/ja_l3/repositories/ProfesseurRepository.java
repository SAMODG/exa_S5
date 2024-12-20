package com.monsite.ja_l3.repositories;

import java.util.List;

import com.monsite.ja_l3.entity.Professeur;

public interface ProfesseurRepository {

    void ajouter(Professeur professeur);

    List<Professeur> listerTous();

    Professeur rechercherParId(int professeurId);
}
