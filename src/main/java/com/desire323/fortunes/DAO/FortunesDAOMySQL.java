package com.desire323.fortunes.DAO;

import com.desire323.fortunes.entity.Fortune;
import com.desire323.fortunes.repository.FortunesRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Repository
public class FortunesDAOMySQL implements FortunesRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public FortunesDAOMySQL(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public Optional<Fortune> getRandomFortune() {
        String sql = "SELECT * FROM fortunes ORDER BY RAND() LIMIT 1";
        Map<String, Object> params = Collections.emptyMap();
        try {
            Fortune fortune = jdbcTemplate.queryForObject(sql, params, BeanPropertyRowMapper.newInstance(Fortune.class));
            System.out.println("\n\n\n" + "Fortune wish :" + fortune.getWish() + "\n\n\n");
            System.out.println("\n\n\n" + "Fortune theme :" + fortune.getTheme() + "\n\n\n");
            return Optional.of(fortune);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}
