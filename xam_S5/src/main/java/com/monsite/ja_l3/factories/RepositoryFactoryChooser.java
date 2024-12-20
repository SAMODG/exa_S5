package com.monsite.ja_l3.factories;

import com.monsite.ja_l3.config.Configuration;

public class RepositoryFactoryChooser {

    public static RepositoryFactory getFactory() {
        // Récupère le mode de stockage depuis la Configuration
        switch (Configuration.getModeStockage()) {
            case BASE_DE_DONNEES:
                return new BdRepositoryFactory(); // Retourne la factory pour la base de données
            case LISTE:
            default:
                return new ListRepositoryFactory(); // Retourne la factory pour le stockage en mémoire (liste)
        }
    }
}
