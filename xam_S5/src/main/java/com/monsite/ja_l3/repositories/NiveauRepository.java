package com.monsite.ja_l3.repositories;

import com.monsite.ja_l3.entity.Niveau;
import java.util.List;

public interface NiveauRepository {
    void ajouter(Niveau niveau);
    List<Niveau> listerTous();
    Niveau rechercherParId(int id);
}
