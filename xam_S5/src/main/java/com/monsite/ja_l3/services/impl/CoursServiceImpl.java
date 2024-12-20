package com.monsite.ja_l3.services.impl;

import java.util.List;

import com.monsite.ja_l3.entity.Classe;
import com.monsite.ja_l3.entity.Cours;
import com.monsite.ja_l3.entity.Niveau;
import com.monsite.ja_l3.entity.Professeur;
import com.monsite.ja_l3.repositories.CoursRepository;
import com.monsite.ja_l3.services.CoursService;

public class CoursServiceImpl implements CoursService {

    private final CoursRepository coursRepository;

    public CoursServiceImpl(CoursRepository coursRepository) {
        this.coursRepository = coursRepository;
    }

    @Override
    public void creerCours(Professeur professeur, String module, List<Classe> classes) {
        
        Cours cours = new Cours(module, professeur, classes, null);
        coursRepository.ajouter(cours);
    }




    @Override
    public List<Cours> listerCoursParNiveau(Niveau niveau) {
        return coursRepository.listerParNiveau(niveau); 
    }

    @Override
    public List<Cours> listerCoursParClasse(int classeId) {
       
        return coursRepository.listerParClasse(classeId);
    }

    @Override
    public List<Cours> listerCoursParProfesseur(int professeurId) {
        
        return coursRepository.listerParProfesseur(professeurId);
    }
}
