package com.monsite.ja_l3.services.impl;

import com.monsite.ja_l3.entity.Niveau;
import com.monsite.ja_l3.repositories.NiveauRepository;
import com.monsite.ja_l3.services.NiveauService;

import java.util.List;

public class NiveauServiceImpl implements NiveauService {

    private final NiveauRepository niveauRepository;

    public NiveauServiceImpl(NiveauRepository niveauRepository) {
        this.niveauRepository = niveauRepository;
    }

    @Override
    public void creerNiveau(String nom) {
        Niveau niveau = new Niveau();
        niveau.setNom(nom);
        niveauRepository.ajouter(niveau);
    }

    @Override
    public List<Niveau> listerNiveaux() {
        return niveauRepository.listerTous();
    }

    @Override
    public Niveau rechercherParId(int id) {
        return niveauRepository.rechercherParId(id);
    }
}
