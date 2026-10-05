package com.example.demo.service;

import com.example.demo.model.Coach;
import com.example.demo.repository.CoachRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoachService {

    private final CoachRepository repository;

    public CoachService(CoachRepository repository) {
        this.repository = repository;
    }

    public List<Coach> findAll() {
        return repository.findAll();
    }

    public Optional<Coach> findById(Long id) {
        return repository.findById(id);
    }

    public Coach create(Coach coach) {
        coach.setId(null);
        return repository.save(coach);
    }

    public Optional<Coach> update(Long id, Coach coach) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }
        coach.setId(id);
        return Optional.of(repository.save(coach));
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}
