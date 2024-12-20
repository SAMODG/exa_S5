package com.monsite.ja_l3.repositories.list;

import com.monsite.ja_l3.entity.Niveau;
import com.monsite.ja_l3.repositories.NiveauRepository;

import java.util.ArrayList;
import java.util.List;

public class NiveauRepositoryList implements NiveauRepository {

    private final List<Niveau> niveaux = new ArrayList<>();
    private int nextId = 1; // Simule un auto-increment ID

    @Override
    public void ajouter(Niveau niveau) {
        niveau.setId(nextId++); // Attribue un ID unique
        niveaux.add(niveau);
    }

    @Override
    public List<Niveau> listerTous() {
        return new ArrayList<>(niveaux); // Retourne une copie pour éviter les modifications externes
    }

    @Override
    public Niveau rechercherParId(int id) {
        return niveaux.stream()
                .filter(niveau -> niveau.getId() == id)
                .findFirst()
                .orElse(null); // Retourne null si aucun niveau trouvé
    }
}
