package com.monsite.ja_l3.repositories.list;


import com.monsite.ja_l3.entity.Cours;
import com.monsite.ja_l3.entity.Niveau;
import com.monsite.ja_l3.repositories.CoursRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CoursRepositoryList implements CoursRepository {

    private final List<Cours> cours = new ArrayList<>();

    @Override
    public void ajouter(Cours cours) {
        cours.setId(this.cours.size() + 1); 
        this.cours.add(cours);
    }

    @Override
    public List<Cours> listerParNiveau(Niveau niveau) {
        return cours.stream()
                    .filter(c -> c.getClasses().stream()
                                  .anyMatch(classe -> classe.getNiveau().equals(niveau)))
                    .collect(Collectors.toList());
    }

    @Override
    public List<Cours> listerParClasse(int classeId) {
        return cours.stream()
                    .filter(c -> c.getClasses().stream()
                                  .anyMatch(classe -> classe.getId() == classeId))
                    .collect(Collectors.toList());
    }

    @Override
    public List<Cours> listerParProfesseur(int professeurId) {
        return cours.stream()
                    .filter(c -> c.getProfesseur().getId() == professeurId)
                    .collect(Collectors.toList());
    }
}
