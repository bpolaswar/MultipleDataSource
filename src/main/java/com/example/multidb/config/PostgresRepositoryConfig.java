package com.example.multidb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.multidb.postgres.repository",
        entityManagerFactoryRef = "postgresEntityManagerFactoryBean",
        transactionManagerRef = "postgresPlatformTransactionManager"
)
public class PostgresRepositoryConfig {
}
