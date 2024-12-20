package com.monsite.ja_l3.repositories;

import com.monsite.ja_l3.entity.Cours;
import com.monsite.ja_l3.entity.Niveau;

import java.util.List;

public interface CoursRepository {

    void ajouter(Cours cours);

    List<Cours> listerParNiveau(Niveau niveau); // Modification ici

    List<Cours> listerParClasse(int classeId);

    List<Cours> listerParProfesseur(int professeurId);
}
