package com.desire323.fortunes.repository;

import com.desire323.fortunes.DTO.SaveWishRequest;
import com.desire323.fortunes.entity.HistoryFortune;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.nio.ByteBuffer;

@Repository
public interface HistoryFortuneRepository {
    void save(SaveWishRequest fortune);
    List<HistoryFortune> findLastByUserId(int id);
    List<HistoryFortune> findByUserId(int userId, int fetchSize, ByteBuffer pagingStateBuffer);
}
