package com.monsite.ja_l3.services.impl;

import java.util.List;

import com.monsite.ja_l3.entity.Professeur;
import com.monsite.ja_l3.repositories.ProfesseurRepository;
import com.monsite.ja_l3.services.ProfesseurService;

public class ProfesseurServiceImpl implements ProfesseurService {

    private final ProfesseurRepository professeurRepository;

    public ProfesseurServiceImpl(ProfesseurRepository professeurRepository) {
        this.professeurRepository = professeurRepository;
    }

    @Override
    public List<Professeur> listerProfesseurs() {
        return professeurRepository.listerTous();
    }

    @Override
    public Professeur rechercherProfesseurParId(int professeurId) {
        return professeurRepository.rechercherParId(professeurId);
    }
}
