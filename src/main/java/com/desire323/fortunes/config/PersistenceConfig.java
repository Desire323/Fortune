package com.desire323.fortunes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfig {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(System.getenv("SPRING_DATASOURCE_DRIVER-CLASS-NAME"));
        dataSource.setUrl(System.getenv("SPRING_DATASOURCE_URL"));
        dataSource.setUsername(System.getenv("SPRING_DATASOURCE_USERNAME"));
        dataSource.setPassword(System.getenv("SPRING_DATASOURCE_PASSWORD"));
        return dataSource;
    }
}

