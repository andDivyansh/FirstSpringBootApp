package com.divyansh.demo.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:postgresql://localhost:5432/Spring");
        dataSourceBuilder.username("postgres");
        dataSourceBuilder.password("divyansh");
        System.out.println("Data source initialised");
        return dataSourceBuilder.build();
    }
}
