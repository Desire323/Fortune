package com.desire323.fortunes.controller;

import com.desire323.fortunes.service.FortunesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController
@RequestMapping("/fortune")
public class FortunesController {

    private final FortunesService fortunesService;

    public FortunesController(FortunesService fortunesService) {
        this.fortunesService = fortunesService;
    }

    @GetMapping("/random")
    public ResponseEntity<String> getRandomFortune() {
        Optional<String> randomFortune = fortunesService.getRandomFortune();
        if(randomFortune.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return ResponseEntity.ok(randomFortune.get());
        }
    }
}
