package com.monsite.ja_l3.entity;
import lombok.Data;
import java.util.Date;

@Data
public class Session {
    private int id;
    private Date date; 
    private String heureDebut; 
    private String heureFin; 
    private String salle;
    private Cours cours; 



    public Session() {}

    public Session(Date date, String heureDebut, String heureFin, String salle, Cours cours) {
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.salle = salle;
        this.cours = cours;
    }
    
    public Session(int id, Date date, String heureDebut, String heureFin, String salle, Cours cours) {
        this.id = id;
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.salle = salle;
        this.cours = cours;
    }
    
}
