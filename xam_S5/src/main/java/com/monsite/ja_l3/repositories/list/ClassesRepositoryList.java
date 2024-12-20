package com.monsite.ja_l3.repositories.list;

import com.monsite.ja_l3.entity.Classe;
import com.monsite.ja_l3.entity.Niveau;
import com.monsite.ja_l3.repositories.ClassesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClassesRepositoryList implements ClassesRepository {

    private final List<Classe> classes = new ArrayList<>();

    @Override
    public void ajouter(Classe classe) {
        classe.setId(classes.size() + 1); // Génération d'ID simulée
        classes.add(classe);
    }

    @Override
    public List<Classe> listerToutes() {
        return new ArrayList<>(classes);
    }

    @Override
    public Classe rechercherParId(int classeId) {
        return classes.stream()
                      .filter(classe -> classe.getId() == classeId)
                      .findFirst()
                      .orElse(null);
    }

    @Override
    public List<Classe> rechercherParNiveau(Niveau niveau) {
        return classes.stream()
                      .filter(classe -> classe.getNiveau().equals(niveau))
                      .collect(Collectors.toList());
    }
}
