package com.monsite.ja_l3.repositories.bd;

import com.monsite.ja_l3.core.bd.DatabaseImpl;
import com.monsite.ja_l3.entity.Cours;
import com.monsite.ja_l3.entity.Niveau;
import com.monsite.ja_l3.repositories.CoursRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CoursRepositoryBd extends DatabaseImpl implements CoursRepository {

    @Override
    public void ajouter(Cours cours) {
        String sql = "INSERT INTO cours (module, professeur_id) VALUES (?, ?)";
        try {
            initPreparedStatement(sql);
            statement.setString(1, cours.getModule());
            statement.setInt(2, cours.getProfesseur().getId());
            executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            int coursId = 0;
            if (generatedKeys.next()) {
                coursId = generatedKeys.getInt(1); // Récupère l'ID généré
            } else {
                throw new SQLException("Échec lors de la création du cours, aucun ID généré.");
            }

            for (var classe : cours.getClasses()) {
                String sqlClasse = "INSERT INTO cours_classes (cours_id, classe_id) VALUES (?, ?)";
                initPreparedStatement(sqlClasse);
                statement.setInt(1, coursId);
                statement.setInt(2, classe.getId());
                executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnexion();
        }
    }

    @Override
    public List<Cours> listerParNiveau(Niveau niveau) {
        String sql = "SELECT c.* FROM cours c " +
                     "JOIN cours_classes cc ON c.id = cc.cours_id " +
                     "JOIN classes cl ON cc.classe_id = cl.id " +
                     "WHERE cl.niveau_id = ?";
        List<Cours> coursList = new ArrayList<>();
        try {
            initPreparedStatement(sql);
            statement.setInt(1, niveau.getId()); // Utilise l'ID de l'objet Niveau
            ResultSet rs = executeSelect();
            while (rs.next()) {
                coursList.add(mapCours(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnexion();
        }
        return coursList;
    }

    @Override
    public List<Cours> listerParClasse(int classeId) {
        String sql = "SELECT c.* FROM cours c " +
                     "JOIN cours_classes cc ON c.id = cc.cours_id " +
                     "WHERE cc.classe_id = ?";
        return listerCours(sql, classeId);
    }

    @Override
    public List<Cours> listerParProfesseur(int professeurId) {
        String sql = "SELECT * FROM cours WHERE professeur_id = ?";
        return listerCours(sql, professeurId);
    }

    private List<Cours> listerCours(String sql, int id) {
        List<Cours> coursList = new ArrayList<>();
        try {
            initPreparedStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = executeSelect();
            while (rs.next()) {
                coursList.add(mapCours(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnexion();
        }
        return coursList;
    }

    private Cours mapCours(ResultSet rs) throws SQLException {
        Cours cours = new Cours();
        cours.setId(rs.getInt("id"));
        cours.setModule(rs.getString("module"));
        // Professeur et classes doivent être mappés séparément
        return cours;
    }
}
