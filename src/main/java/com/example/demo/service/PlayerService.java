package com.example.demo.service;

import com.example.demo.model.Player;
import com.example.demo.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    private final PlayerRepository repository;

    public PlayerService(PlayerRepository repository) {
        this.repository = repository;
    }

    public List<Player> findAll() {
        return repository.findAll();
    }

    public Optional<Player> findById(Long id) {
        return repository.findById(id);
    }

    public Player create(Player player) {
        player.setId(null);
        return repository.save(player);
    }

    public Optional<Player> update(Long id, Player player) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }
        player.setId(id);
        return Optional.of(repository.save(player));
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
