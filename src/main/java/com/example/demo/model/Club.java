package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Club {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nom;
    String coach;
    float effective;
    float budget;

    @OneToMany(mappedBy = "club")
    List<Player> players = new ArrayList<>();

    public Club() {
    }

    public Club(String nom, String coach, float effective, float budget) {
        this.nom = nom;
        this.coach = coach;
        this.effective = effective;
        this.budget = budget;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public float getEffective() {
        return effective;
    }

    public void setEffective(float effective) {
        this.effective = effective;
    }

    public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }


    public List<Player> getPlayers() {
        return players;
    }
}