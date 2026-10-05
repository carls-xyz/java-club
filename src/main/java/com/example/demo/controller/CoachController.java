package com.example.demo.controller;

import com.example.demo.model.Coach;
import com.example.demo.service.CoachService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coachs")
public class CoachController {

    private final CoachService service;

    public CoachController(CoachService service) {
        this.service = service;
    }

    @GetMapping
    public List<Coach> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coach> getOne(@PathVariable Long id) {
        return ResponseEntity.of(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Coach> create(@RequestBody Coach coach) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(coach));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coach> update(@PathVariable Long id, @RequestBody Coach coach) {
        return ResponseEntity.of(service.update(id, coach));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return service.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
