package com.desire323.fortunes.service;

import com.desire323.fortunes.DTO.SaveWishRequest;
import com.desire323.fortunes.DTO.Wish;
import com.desire323.fortunes.entity.HistoryFortune;
import com.desire323.fortunes.repository.HistoryFortuneRepository;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.Base64;
import java.util.List;


@Service
public class HistoryFortuneService {

    private final HistoryFortuneRepository historyFortuneRepository;

    public HistoryFortuneService(HistoryFortuneRepository historyFortuneRepository) {
        this.historyFortuneRepository = historyFortuneRepository;
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

        return historyFortuneRepository.findByUserId(Integer.parseInt(userId), 10, pagingState);
    }

    public List<HistoryFortune> getLastWish (String userId) {
        return historyFortuneRepository.findLastByUserId(Integer.parseInt(userId));
    }

}
