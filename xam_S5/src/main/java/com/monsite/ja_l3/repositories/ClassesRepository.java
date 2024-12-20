package com.monsite.ja_l3.repositories;

import com.monsite.ja_l3.entity.Classe;
import com.monsite.ja_l3.entity.Niveau;

import java.util.List;

public interface ClassesRepository {

    void ajouter(Classe classe);

    List<Classe> listerToutes();

    Classe rechercherParId(int classeId);

    List<Classe> rechercherParNiveau(Niveau niveau); 
}
