package com.monsite.ja_l3.repositories.bd;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.monsite.ja_l3.core.bd.DatabaseImpl;
import com.monsite.ja_l3.entity.Professeur;
import com.monsite.ja_l3.repositories.ProfesseurRepository;

public class ProfesseurRepositoryBd extends DatabaseImpl implements ProfesseurRepository {

    @Override
    public void ajouter(Professeur professeur) {
        String sql = "INSERT INTO professeurs (nom) VALUES (?, ?)";
        try {
            initPreparedStatement(sql);
            statement.setString(1, professeur.getNom());
            executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnexion();
        }
    }

    @Override
    public List<Professeur> listerTous() {
        String sql = "SELECT * FROM professeurs";
        List<Professeur> professeurs = new ArrayList<>();
        try {
            initPreparedStatement(sql);
            ResultSet rs = executeSelect();
            while (rs.next()) {
                Professeur professeur = mapProfesseur(rs);
                professeurs.add(professeur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnexion();
        }
        return professeurs;
    }

    @Override
    public Professeur rechercherParId(int professeurId) {
        String sql = "SELECT * FROM professeurs WHERE id = ?";
        Professeur professeur = null;
        try {
            initPreparedStatement(sql);
            statement.setInt(1, professeurId);
            ResultSet rs = executeSelect();
            if (rs.next()) {
                professeur = mapProfesseur(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnexion();
        }
        return professeur;
    }

    private Professeur mapProfesseur(ResultSet rs) throws SQLException {
        Professeur professeur = new Professeur();
        professeur.setId(rs.getInt("id"));
        professeur.setNom(rs.getString("nom"));
        return professeur;
    }
}
