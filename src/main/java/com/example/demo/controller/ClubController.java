package com.example.demo.controller;

import com.example.demo.model.Club;
import com.example.demo.service.ClubService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    private final ClubService service;

    public ClubController(ClubService service) {
        this.service = service;
    }

    @GetMapping
    public List<Club> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Club> getOne(@PathVariable Long id) {
        return ResponseEntity.of(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Club> create(@RequestBody Club club) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(club));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Club> update(@PathVariable Long id, @RequestBody Club club) {
        return ResponseEntity.of(service.update(id, club));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
    @PutMapping("/{clubId}/players/{playerId}")
    public ResponseEntity<Club> addPlayer(@PathVariable Long clubId, @PathVariable Long playerId) {
        return ResponseEntity.of(service.addPlayer(clubId, playerId));
    }
}
