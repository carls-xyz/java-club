package com.example.demo.controller;

import com.example.demo.model.Player;
import com.example.demo.service.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping
    public List<Player> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getOne(@PathVariable Long id) {
        return ResponseEntity.of(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Player> create(@RequestBody Player player) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(player));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> update(@PathVariable Long id, @RequestBody Player player) {
        return ResponseEntity.of(service.update(id, player));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
