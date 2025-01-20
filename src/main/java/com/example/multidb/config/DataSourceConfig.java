package com.example.multidb.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "mysqlDatasource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource mysqlDatasource() {
        return DataSourceBuilder.create()
                .build();
    }

    @Bean(name = "postgresDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.postgres")
    public DataSource postgresDatasource() {
        return DataSourceBuilder.create().build();
    }
}
