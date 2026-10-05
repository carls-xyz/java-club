package com.example.demo.controller;

import com.example.demo.service.MatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/match")
public class MatchController {

    private final MatchService service;

    public MatchController(MatchService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> jouer(@RequestParam Long club1, @RequestParam Long club2) {
        return ResponseEntity.of(service.jouer(club1, club2));
    }
}