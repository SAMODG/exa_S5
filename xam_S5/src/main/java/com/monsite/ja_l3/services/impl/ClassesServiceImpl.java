package com.monsite.ja_l3.services.impl;

import java.util.List;

import com.monsite.ja_l3.entity.Classe;
import com.monsite.ja_l3.entity.Niveau;
import com.monsite.ja_l3.repositories.ClassesRepository;
import com.monsite.ja_l3.services.ClassesService;

public class ClassesServiceImpl implements ClassesService {

    private final ClassesRepository classesRepository;

    public ClassesServiceImpl(ClassesRepository classesRepository) {
        this.classesRepository = classesRepository;
    }

    @Override
    public void creerClasse(String nom, Niveau niveau) {
        Classe classe = new Classe(nom, niveau); // Le constructeur Classe prend maintenant un Niveau directement
        classesRepository.ajouter(classe);
    }

    @Override
    public List<Classe> listerClasses() {
        return classesRepository.listerToutes();
    }

    @Override
    public Classe rechercherClasseParId(int classeId) {
        return classesRepository.rechercherParId(classeId);
    }
}
