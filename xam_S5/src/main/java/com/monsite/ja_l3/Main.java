package com.monsite.ja_l3;

import com.monsite.ja_l3.config.Configuration;
import com.monsite.ja_l3.repositories.ClassesRepository;
import com.monsite.ja_l3.repositories.CoursRepository;
import com.monsite.ja_l3.repositories.ProfesseurRepository;
import com.monsite.ja_l3.repositories.NiveauRepository;
import com.monsite.ja_l3.repositories.bd.ClassesRepositoryBd;
import com.monsite.ja_l3.repositories.bd.CoursRepositoryBd;
import com.monsite.ja_l3.repositories.bd.NiveauRepositoryBd;
import com.monsite.ja_l3.repositories.bd.ProfesseurRepositoryBd;
import com.monsite.ja_l3.repositories.list.ClassesRepositoryList;
import com.monsite.ja_l3.repositories.list.CoursRepositoryList;
import com.monsite.ja_l3.repositories.list.NiveauRepositoryList;
import com.monsite.ja_l3.repositories.list.ProfesseurRepositoryList;
import com.monsite.ja_l3.services.ClassesService;
import com.monsite.ja_l3.services.CoursService;
import com.monsite.ja_l3.services.NiveauService;
import com.monsite.ja_l3.services.impl.ClassesServiceImpl;
import com.monsite.ja_l3.services.impl.CoursServiceImpl;
import com.monsite.ja_l3.services.impl.NiveauServiceImpl;
import com.monsite.ja_l3.views.AdminView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        choisirModeStockage(scanner);

        ClassesRepository classesRepository;
        CoursRepository coursRepository;
        ProfesseurRepository professeurRepository;
        NiveauRepository niveauRepository;

        if (Configuration.getModeStockage() == Configuration.ModeStockage.BASE_DE_DONNEES) {
            classesRepository = new ClassesRepositoryBd();
            coursRepository = new CoursRepositoryBd();
            professeurRepository = new ProfesseurRepositoryBd();
            niveauRepository = new NiveauRepositoryBd();
        } else {
            classesRepository = new ClassesRepositoryList();
            coursRepository = new CoursRepositoryList();
            professeurRepository = new ProfesseurRepositoryList();
            niveauRepository = new NiveauRepositoryList();
        }

        // Initialisation des services
        ClassesService classesService = new ClassesServiceImpl(classesRepository);
        CoursService coursService = new CoursServiceImpl(coursRepository);
        NiveauService niveauService = new NiveauServiceImpl(niveauRepository);

       
        AdminView adminView = new AdminView(coursService, classesService, niveauService);
        afficherMenuAdmin(scanner, adminView);

        System.out.println("Application terminée.");
        scanner.close();
    }

    private static void choisirModeStockage(Scanner scanner) {
        System.out.println("=== Choix du Mode de Stockage ===");
        System.out.println("1. Stockage en base de données");
        System.out.println("2. Stockage en liste (mémoire)");
        System.out.println("3. Quitter l'application");
        System.out.print("Choisissez une option : ");

        int choix = scanner.nextInt();
        scanner.nextLine();

        switch (choix) {
            case 1 -> {
                Configuration.setModeStockage(Configuration.ModeStockage.BASE_DE_DONNEES);
                System.out.println("Mode de stockage : BASE DE DONNÉES");
            }
            case 2 -> {
                Configuration.setModeStockage(Configuration.ModeStockage.LISTE);
                System.out.println("Mode de stockage : LISTE (en mémoire)");
            }
            case 3 -> {
                System.out.println("Vous avez quitté l'application.");
                System.exit(0);
            }
            default -> {
                System.out.println("Option invalide. Mode LISTE sélectionné par défaut.");
                Configuration.setModeStockage(Configuration.ModeStockage.LISTE);
            }
        }
    }

    private static void afficherMenuAdmin(Scanner scanner, AdminView adminView) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Menu Administrateur ===");
            System.out.println("1. Créer un cours");
            System.out.println("2. Créer un niveau");
            System.out.println("3. Créer une classe");
            System.out.println("4. Afficher les cours par niveau");
            System.out.println("5. Afficher les cours par classe");
            System.out.println("6. Afficher les cours par professeur");
            System.out.println("7. Quitter");
            System.out.print("Choisissez une option : ");

            try {
                int choix = scanner.nextInt();
                scanner.nextLine(); 

                switch (choix) {
                    case 1 -> adminView.creerCours();
                    case 2 -> adminView.creerNiveau();
                    case 3 -> adminView.creerClasse();
                    case 4 -> adminView.afficherCoursParNiveau();
                    case 5 -> adminView.afficherCoursParClasse();
                    case 6 -> adminView.afficherCoursParProfesseur();
                    case 7 -> {
                        running = false;
                        System.out.println("Retour au menu principal.");
                    }
                    default -> System.out.println("Option invalide. Veuillez réessayer.");
                }
            } catch (Exception e) {
                System.out.println("Entrée invalide. Veuillez entrer un chiffre.");
                scanner.nextLine(); 
            }
        }
    }
}
