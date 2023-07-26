package com.desire323.fortunes.DAO;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.*;
import com.desire323.fortunes.DTO.SaveWishRequest;
import com.desire323.fortunes.entity.HistoryFortune;
import com.desire323.fortunes.repository.HistoryFortuneRepository;
import org.springframework.stereotype.Repository;

import java.nio.ByteBuffer;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Repository
public class HistoryDAOCassandra implements HistoryFortuneRepository {
    private final CqlSession cqlSession;

    private final PreparedStatement saveStatement;
    private final PreparedStatement findByUserIdStatement;

    public HistoryDAOCassandra(CqlSession cqlSession) {
        this.cqlSession = cqlSession;

        this.saveStatement = cqlSession.prepare(
                "INSERT INTO history.fortunes (userId, wish, theme, date) VALUES (?, ?, ?, ?)"
        );

        this.findByUserIdStatement = cqlSession.prepare(
                "SELECT * FROM history.fortunes WHERE userId = ? order by date desc"
        );
    }

    public void save(SaveWishRequest fortune) {
        BoundStatement boundStatement = saveStatement.bind(fortune.getUserId(), fortune.getWish(), fortune.getTheme(), Instant.now());
        cqlSession.execute(boundStatement);
    }

    public List<HistoryFortune> findByUserId(int userId, int fetchSize, ByteBuffer pagingStateBuffer) {
        BoundStatement boundStatement = findByUserIdStatement.bind(userId).setPageSize(fetchSize).setPagingState(pagingStateBuffer);
        ResultSet resultSet = cqlSession.execute(boundStatement);
        return mapResultSetToList(resultSet);
    }

    private List<HistoryFortune> mapResultSetToList(ResultSet resultSet) {
        List<HistoryFortune> fortunes = new ArrayList<>();
        for (Row row : resultSet) {
            HistoryFortune fortune = new HistoryFortune();
            fortune.setUserId(row.getInt("userId"));
            fortune.setWish(row.getString("wish"));
            fortune.setTheme(row.getString("theme"));
            fortune.setDate(row.getInstant("date"));
            fortunes.add(fortune);
        }
        return fortunes;
    }
}

