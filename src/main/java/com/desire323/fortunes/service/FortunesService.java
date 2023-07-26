package com.desire323.fortunes.service;

import com.desire323.fortunes.DTO.SaveWishRequest;
import com.desire323.fortunes.DTO.Wish;
import com.desire323.fortunes.entity.Fortune;
import com.desire323.fortunes.entity.HistoryFortune;
import com.desire323.fortunes.repository.FortunesRepository;
import com.desire323.fortunes.repository.HistoryFortuneRepository;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class FortunesService {

    private final FortunesRepository fortunesRepository;
    private final HistoryFortuneRepository historyFortuneRepository;

    public FortunesService(FortunesRepository fortunesRepository, HistoryFortuneService historyFortuneService, HistoryFortuneRepository historyFortuneRepository) {
        this.fortunesRepository = fortunesRepository;
        this.historyFortuneRepository = historyFortuneRepository;
    }

    public Optional<Wish> getRandomFortune() {
        Optional<Fortune> randomFortune = fortunesRepository.getRandomFortune();
        if(randomFortune.isEmpty()) {
            return Optional.empty();
        }
        else {
            Fortune fortune = randomFortune.get();
            Wish wish = new Wish(fortune.getWish(), fortune.getTheme());
            return Optional.of(wish);
        }
    }

    public void saveWish(String userId, Wish wish) {
        SaveWishRequest saveWishRequest = new SaveWishRequest(Integer.parseInt(userId), wish.getWish(), wish.getTheme());
        historyFortuneRepository.save(saveWishRequest);
    }
    public List<HistoryFortune> getWishes(String userId, String pagingStateString) {
        ByteBuffer pagingState = null;
        if (pagingStateString != null) {
            byte[] pagingStateBytes = Base64.getDecoder().decode(pagingStateString);
            pagingState = ByteBuffer.wrap(pagingStateBytes);
        }

        return historyFortuneRepository.findByUserId(Integer.parseInt(userId), 2, pagingState);
    }

}
