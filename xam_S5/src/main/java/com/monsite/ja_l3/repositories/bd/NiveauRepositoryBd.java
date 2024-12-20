package com.monsite.ja_l3.repositories.bd;


import com.monsite.ja_l3.core.bd.DatabaseImpl;
import com.monsite.ja_l3.entity.Niveau;
import com.monsite.ja_l3.repositories.NiveauRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NiveauRepositoryBd extends DatabaseImpl implements NiveauRepository {

    @Override
    public void ajouter(Niveau niveau) {
        String sql = "INSERT INTO niveaux (nom) VALUES (?)";
        try {
            initPreparedStatement(sql);
            statement.setString(1, niveau.getNom());
            executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnexion();
        }
    }

    @Override
    public List<Niveau> listerTous() {
        String sql = "SELECT * FROM niveaux";
        List<Niveau> niveaux = new ArrayList<>();
        try {
            initPreparedStatement(sql);
            ResultSet rs = executeSelect();
            while (rs.next()) {
                niveaux.add(mapNiveau(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnexion();
        }
        return niveaux;
    }

    @Override
    public Niveau rechercherParId(int id) {
        String sql = "SELECT * FROM niveaux WHERE id = ?";
        try {
            initPreparedStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = executeSelect();
            if (rs.next()) {
                return mapNiveau(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnexion();
        }
        return null;
    }

    private Niveau mapNiveau(ResultSet rs) throws SQLException {
        Niveau niveau = new Niveau();
        niveau.setId(rs.getInt("id"));
        niveau.setNom(rs.getString("nom"));
        return niveau;
    }
}
