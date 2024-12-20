package com.monsite.ja_l3.repositories.bd;

import com.monsite.ja_l3.core.bd.DatabaseImpl;
import com.monsite.ja_l3.entity.Classe;
import com.monsite.ja_l3.entity.Niveau;
import com.monsite.ja_l3.repositories.ClassesRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassesRepositoryBd extends DatabaseImpl implements ClassesRepository {

    @Override
    public void ajouter(Classe classe) {
        String sql = "INSERT INTO classes (nom, niveau_id) VALUES (?, ?)";
        try {
            initPreparedStatement(sql);
            statement.setString(1, classe.getNom());
            statement.setInt(2, classe.getNiveau().getId());
            executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnexion();
        }
    }

    @Override
    public List<Classe> listerToutes() {
        String sql = "SELECT c.*, n.nom AS niveau_nom FROM classes c " +
                     "JOIN niveaux n ON c.niveau_id = n.id";
        List<Classe> classes = new ArrayList<>();
        try {
            initPreparedStatement(sql);
            ResultSet rs = executeSelect();
            while (rs.next()) {
                classes.add(mapClasse(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnexion();
        }
        return classes;
    }

    @Override
    public Classe rechercherParId(int classeId) {
        String sql = "SELECT c.*, n.nom AS niveau_nom FROM classes c " +
                     "JOIN niveaux n ON c.niveau_id = n.id WHERE c.id = ?";
        Classe classe = null;
        try {
            initPreparedStatement(sql);
            statement.setInt(1, classeId);
            ResultSet rs = executeSelect();
            if (rs.next()) {
                classe = mapClasse(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnexion();
        }
        return classe;
    }

    @Override
    public List<Classe> rechercherParNiveau(Niveau niveau) {
        String sql = "SELECT c.*, n.nom AS niveau_nom FROM classes c " +
                     "JOIN niveaux n ON c.niveau_id = n.id WHERE c.niveau_id = ?";
        List<Classe> classes = new ArrayList<>();
        try {
            initPreparedStatement(sql);
            statement.setInt(1, niveau.getId());
            ResultSet rs = executeSelect();
            while (rs.next()) {
                classes.add(mapClasse(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnexion();
        }
        return classes;
    }

    private Classe mapClasse(ResultSet rs) throws SQLException {
        Classe classe = new Classe();
        classe.setId(rs.getInt("id"));
        classe.setNom(rs.getString("nom"));
        
        Niveau niveau = new Niveau();
        niveau.setId(rs.getInt("niveau_id"));
        niveau.setNom(rs.getString("niveau_nom"));
        classe.setNiveau(niveau);

        return classe;
    }
}
