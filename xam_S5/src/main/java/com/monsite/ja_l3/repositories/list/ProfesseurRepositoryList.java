package com.monsite.ja_l3.repositories.list;

import com.monsite.ja_l3.entity.Professeur;
import com.monsite.ja_l3.repositories.ProfesseurRepository;

import java.util.ArrayList;
import java.util.List;

public class ProfesseurRepositoryList implements ProfesseurRepository {
    private List<Professeur> professeurs = new ArrayList<>();
    private int nextId = 1; // Simule l'auto-incrémentation des IDs

    @Override
    public void ajouter(Professeur professeur) {
        professeur.setId(nextId++);
        professeurs.add(professeur);
    }

    @Override
    public List<Professeur> listerTous() {
        return new ArrayList<>(professeurs); // Retourne une copie pour éviter les modifications directes
    }

    @Override
    public Professeur rechercherParId(int professeurId) {
        return professeurs.stream()
                .filter(professeur -> professeur.getId() == professeurId)
                .findFirst()
                .orElse(null);
    }
}
