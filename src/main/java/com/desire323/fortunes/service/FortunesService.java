package com.desire323.fortunes.service;

import com.desire323.fortunes.entity.Fortune;
import com.desire323.fortunes.repository.FortunesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FortunesService {

    private final FortunesRepository fortunesRepository;

    public FortunesService(FortunesRepository fortunesRepository) {
        this.fortunesRepository = fortunesRepository;
    }

    public Optional<String> getRandomFortune() {
        Optional<Fortune> randomFortune = fortunesRepository.getRandomFortune();
        if(randomFortune.isEmpty()) {
            return Optional.empty();
        }
        else {
            System.out.println("\n\n\n" + randomFortune);
            System.out.println("\n" + randomFortune.get());
            System.out.println("\n" + randomFortune.get().getWish() + "\n\n\n");
            return Optional.of(randomFortune.get().getWish());
        }
    }
}
