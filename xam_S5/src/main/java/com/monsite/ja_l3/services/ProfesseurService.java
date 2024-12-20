package com.monsite.ja_l3.services;

import java.util.List;

import com.monsite.ja_l3.entity.Professeur;

public interface ProfesseurService {

    List<Professeur> listerProfesseurs();

    Professeur rechercherProfesseurParId(int professeurId);
}
