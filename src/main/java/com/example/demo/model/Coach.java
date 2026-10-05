package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coach implements Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String nom;
    String nationality;
    float salary;

    public Coach() {
    }

    public Coach(String nom, String nationality, float salary) {
        this.nom = nom;
        this.nationality = nationality;
        this.salary = salary;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public float getSalary() { return salary; }
    public void setSalary(float salary) { this.salary = salary; }

    @Override
    public void time(float time) {
        System.out.println(120);
    }

    @Override
    public void giveInstructions(String instructions) {
        System.out.println("Commencez à vous échauffer");
    }

    @Override
    public void giveExercise(String exercise) {
        System.out.println("test");
    }
}
