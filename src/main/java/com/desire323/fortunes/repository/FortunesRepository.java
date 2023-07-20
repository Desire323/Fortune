package com.desire323.fortunes.repository;

import com.desire323.fortunes.entity.Fortune;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FortunesRepository {
    Optional<Fortune> getRandomFortune();
}
