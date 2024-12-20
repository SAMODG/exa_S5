package com.monsite.ja_l3.services;

import java.util.List;

import com.monsite.ja_l3.entity.Classe;
import com.monsite.ja_l3.entity.Cours;
import com.monsite.ja_l3.entity.Niveau;
import com.monsite.ja_l3.entity.Professeur;

public interface CoursService {

    void creerCours(Professeur professeur, String module, List<Classe> classes);

    List<Cours> listerCoursParNiveau(Niveau niveau); 


    List<Cours> listerCoursParClasse(int classeId);

    List<Cours> listerCoursParProfesseur(int professeurId);
}
