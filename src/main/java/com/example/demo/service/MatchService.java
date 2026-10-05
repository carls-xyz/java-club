package com.example.demo.service;

import com.example.demo.model.Club;
import com.example.demo.repository.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class MatchService {

    private final ClubRepository clubRepository;
    private final Random random = new Random();

    public MatchService(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    private int force(Club club) {
        return club.getPlayers().size() + (int) (club.getBudget() / 100) + random.nextInt(6);
    }

    public Optional<String> jouer(Long club1Id, Long club2Id) {
        Optional<Club> club1 = clubRepository.findById(club1Id);
        Optional<Club> club2 = clubRepository.findById(club2Id);
        if (club1.isEmpty() || club2.isEmpty()) {
            return Optional.empty();
        }

        int score1 = force(club1.get()) % 5;
        int score2 = force(club2.get()) % 5;

        String resultat = club1.get().getNom() + " " + score1 + " - " + score2 + " " + club2.get().getNom() + ". ";
        if (score1 == score2) {
            return Optional.of(resultat + "Match nul");
        }
        String gagnant = score1 > score2 ? club1.get().getNom() : club2.get().getNom();
        return Optional.of(resultat + "Victoire de " + gagnant + " !");
    }
}