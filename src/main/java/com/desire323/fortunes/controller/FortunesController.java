package com.desire323.fortunes.controller;

import com.desire323.fortunes.DTO.Wish;
import com.desire323.fortunes.entity.HistoryFortune;
import com.desire323.fortunes.service.FortunesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fortune")
public class FortunesController {

    private final FortunesService fortunesService;

    public FortunesController(FortunesService fortunesService) {
        this.fortunesService = fortunesService;
    }

    @GetMapping("/random") //not every rest
    public ResponseEntity<Wish> getRandomFortune(@RequestHeader("x-auth-user-id") String userId) {
        Optional<Wish> randomFortune = fortunesService.getRandomFortune();
        System.out.println("\n\n\n" + "User id  :" + userId + "\n\n\n");
        if(randomFortune.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            Wish wish = randomFortune.get();
            fortunesService.saveWish(userId, wish);
            return ResponseEntity.ok(wish);
        }
    }
    @GetMapping("/history")
    public List<HistoryFortune> getWishes(@RequestHeader("x-auth-user-id") String userId, @RequestParam(required = false) String pagingState) {
        return fortunesService.getWishes(userId, pagingState);
    }
}
