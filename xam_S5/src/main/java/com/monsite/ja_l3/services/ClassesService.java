package com.monsite.ja_l3.services;

import java.util.List;
import com.monsite.ja_l3.entity.Classe;
import com.monsite.ja_l3.entity.Niveau;

public interface ClassesService {

    void creerClasse(String nom, Niveau niveau);

    List<Classe> listerClasses();

    Classe rechercherClasseParId(int classeId);
}
