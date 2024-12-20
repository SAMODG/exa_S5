package com.monsite.ja_l3.services;

import com.monsite.ja_l3.entity.Niveau;
import java.util.List;

public interface NiveauService {
    void creerNiveau(String nom);
    List<Niveau> listerNiveaux();
    Niveau rechercherParId(int id);
}
