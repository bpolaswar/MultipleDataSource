package com.example.multidb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.example.multidb.mysql.repository",
        entityManagerFactoryRef = "mysqlEntityManagerFactoryBean",
        transactionManagerRef = "mysqlPlatformTransactionManager"
)
public class MysqlRepositoryConfig {
}
