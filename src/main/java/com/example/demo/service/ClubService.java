package com.example.demo.service;

import com.example.demo.model.Club;
import com.example.demo.repository.ClubRepository;
import org.springframework.stereotype.Service;
import com.example.demo.model.Player;
import com.example.demo.repository.PlayerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClubService {

    private final ClubRepository repository;
    private final PlayerRepository playerRepository;

    public ClubService(ClubRepository repository, PlayerRepository playerRepository) {
        this.repository = repository;
        this.playerRepository = playerRepository;
    }

    public List<Club> findAll() {
        return repository.findAll();
    }

    public Optional<Club> findById(Long id) {
        return repository.findById(id);
    }

    public Club create(Club club) {
        club.setId(null);
        return repository.save(club);
    }

    public Optional<Club> update(Long id, Club club) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }
        club.setId(id);
        return Optional.of(repository.save(club));
    }

    public boolean delete(Long id) {
        Optional<Club> club = repository.findById(id);
        if (club.isEmpty()) {
            return false;
        }
        for (Player player : club.get().getPlayers()) {
            player.setClub(null);
            playerRepository.save(player);
        }
        repository.deleteById(id);
        return true;
    }
        public Optional<Club> addPlayer(Long clubId, Long playerId) {
            Optional<Club> club = repository.findById(clubId);
            Optional<Player> player = playerRepository.findById(playerId);
            if (club.isEmpty() || player.isEmpty()) {
                return Optional.empty();
            }
            player.get().setClub(club.get());
            playerRepository.save(player.get());
            club.get().getPlayers().add(player.get());
            return club;

        }}
