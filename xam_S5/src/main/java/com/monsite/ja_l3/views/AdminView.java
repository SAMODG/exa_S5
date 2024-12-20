package com.monsite.ja_l3.views;

import com.monsite.ja_l3.entity.Classe;
import com.monsite.ja_l3.entity.Cours;
import com.monsite.ja_l3.entity.Niveau;
import com.monsite.ja_l3.entity.Professeur;
import com.monsite.ja_l3.services.ClassesService;
import com.monsite.ja_l3.services.CoursService;
import com.monsite.ja_l3.services.NiveauService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminView {

    private final CoursService coursService;
    private final ClassesService classesService;
    private final NiveauService niveauService;
    private final Scanner scanner;

    public AdminView(CoursService coursService, ClassesService classesService, NiveauService niveauService) {
        this.coursService = coursService;
        this.classesService = classesService;
        this.niveauService = niveauService;
        this.scanner = new Scanner(System.in);
    }

    // 1. Créer un cours
    public void creerCours() {
        System.out.println("\n=== Créer un Cours ===");
        System.out.print("Nom du module : ");
        String module = scanner.nextLine();

        System.out.print("Nom du professeur : ");
        String nomProfesseur = scanner.nextLine();

        System.out.print("Spécialité du professeur : ");
        String specialite = scanner.nextLine();

        Professeur professeur = new Professeur();
        professeur.setNom(nomProfesseur);
        professeur.setSpecialite(specialite);

        List<Classe> classes = selectionnerClasses();
        if (classes.isEmpty()) {
            System.out.println("Aucune classe sélectionnée. Annulation de la création du cours.");
            return;
        }

        coursService.creerCours(professeur, module, classes);
        System.out.println("Cours créé avec succès !");
    }

    // 2. Créer un niveau
    public void creerNiveau() {
        System.out.println("\n=== Créer un Niveau ===");
        System.out.print("Nom du niveau : ");
        String nom = scanner.nextLine();

        niveauService.creerNiveau(nom);
        System.out.println("Niveau " + nom + " créé avec succès !");
    }

    // 3. Créer une classe
    public void creerClasse() {
        System.out.println("\n=== Créer une Classe ===");
        System.out.print("Nom de la classe : ");
        String nom = scanner.nextLine();

        List<Niveau> niveaux = niveauService.listerNiveaux();
        if (niveaux.isEmpty()) {
            System.out.println("Aucun niveau disponible. Annulation de la création de classe.");
            return;
        }

        System.out.println("Sélectionnez un niveau :");
        for (int i = 0; i < niveaux.size(); i++) {
            System.out.println((i + 1) + ". " + niveaux.get(i).getNom());
        }

        int choix = getChoixUtilisateur(1, niveaux.size());
        if (choix != -1) {
            Niveau niveauChoisi = niveaux.get(choix - 1);
            classesService.creerClasse(nom, niveauChoisi);
            System.out.println("Classe créée avec succès !");
        } else {
            System.out.println("Annulation de la création de classe.");
        }
    }

    // 4. Afficher les cours par niveau
    public void afficherCoursParNiveau() {
        System.out.println("\n=== Afficher les Cours par Niveau ===");
        List<Niveau> niveaux = niveauService.listerNiveaux();
        if (niveaux.isEmpty()) {
            System.out.println("Aucun niveau disponible.");
            return;
        }

        System.out.println("Sélectionnez un niveau :");
        for (int i = 0; i < niveaux.size(); i++) {
            System.out.println((i + 1) + ". " + niveaux.get(i).getNom());
        }

        int choix = getChoixUtilisateur(1, niveaux.size());
        if (choix != -1) {
            Niveau niveauChoisi = niveaux.get(choix - 1);
            List<Cours> cours = coursService.listerCoursParNiveau(niveauChoisi);
            afficherListeCours(cours);
        } else {
            System.out.println("Annulation de l'affichage.");
        }
    }

    // 5. Afficher les cours par classe
    public void afficherCoursParClasse() {
        System.out.println("\n=== Afficher les Cours par Classe ===");
        List<Classe> classes = classesService.listerClasses();
        if (classes.isEmpty()) {
            System.out.println("Aucune classe disponible.");
            return;
        }

        System.out.println("Sélectionnez une classe :");
        for (int i = 0; i < classes.size(); i++) {
            System.out.println((i + 1) + ". " + classes.get(i).getNom());
        }

        int choix = getChoixUtilisateur(1, classes.size());
        if (choix != -1) {
            Classe classeChoisie = classes.get(choix - 1);
            List<Cours> cours = coursService.listerCoursParClasse(classeChoisie.getId());
            afficherListeCours(cours);
        } else {
            System.out.println("Annulation de l'affichage.");
        }
    }

    // 6. Afficher les cours par professeur
    public void afficherCoursParProfesseur() {
        System.out.println("\n=== Afficher les Cours par Professeur ===");
        System.out.print("ID du professeur : ");
        int professeurId = scanner.nextInt();
        scanner.nextLine(); // Consomme la nouvelle ligne

        List<Cours> cours = coursService.listerCoursParProfesseur(professeurId);
        afficherListeCours(cours);
    }

    // Méthode utilitaire pour afficher une liste de cours
    private void afficherListeCours(List<Cours> cours) {
        if (cours.isEmpty()) {
            System.out.println("Aucun cours trouvé.");
        } else {
            System.out.println("Cours :");
            for (Cours c : cours) {
                System.out.println("- " + c.getModule() + " (Professeur : " + c.getProfesseur().getNom() + ")");
            }
        }
    }

    // Méthode utilitaire pour sélectionner des classes
    private List<Classe> selectionnerClasses() {
        List<Classe> classes = classesService.listerClasses();
        if (classes.isEmpty()) {
            System.out.println("Aucune classe disponible.");
            return new ArrayList<>();
        }

        System.out.println("Sélectionnez les classes (saisir 0 pour terminer) :");
        for (int i = 0; i < classes.size(); i++) {
            System.out.println((i + 1) + ". " + classes.get(i).getNom());
        }

        List<Classe> classesChoisies = new ArrayList<>();
        while (true) {
            int choix = getChoixUtilisateur(0, classes.size());
            if (choix == 0) break;
            classesChoisies.add(classes.get(choix - 1));
        }
        return classesChoisies;
    }

    // Méthode utilitaire pour gérer les choix utilisateur
    private int getChoixUtilisateur(int min, int max) {
        try {
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consomme l'entrée
            if (choix >= min && choix <= max) {
                return choix;
            }
        } catch (Exception e) {
            scanner.nextLine(); // Nettoyage de l'entrée invalide
        }
        System.out.println("Option invalide. Réessayez.");
        return -1; // Code d'erreur pour un choix invalide
    }
}
