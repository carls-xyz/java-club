package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Player implements Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nom;
    String position;
    float number;

    @ManyToOne
    @JoinColumn(name = "club_id")
    @JsonIgnore
    Club club;

    public Player() {
    }

    public Player(String nom, String position, float number) {
        this.nom = nom;
        this.position = position;
        this.number = number;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public float getNumber() { return number; }
    public void setNumber(float number) { this.number = number; }

    public Club getClub() { return club; }
    public void setClub(Club club) { this.club = club; }

    @Override
    public void time(float time) {
        System.out.println(120);
    }

    @Override
    public void giveInstructions(String instructions) {
        System.out.println("Ok coach");
    }

    @Override
    public void giveExercise(String exercise) {
        System.out.println("test");
    }
}
