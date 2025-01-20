package com.example.multidb;


import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
public class JpaConfig {

    @Bean(name = "mysqlEntityManagerFactoryBean")
    @Primary
    public LocalContainerEntityManagerFactoryBean mysqlEntityManagerFactoryBean(
            EntityManagerFactoryBuilder builder, @Qualifier("mysqlDatasource") DataSource dataSource
            ) {
        return builder.dataSource(dataSource)
                .packages("com.example.multidb.mysql.entity")
                .properties(Map.of("hibernate.dialect", "org.hibernate.dialect.MySQLDialect",
                        "hibernate.show_sql", "true",
                        "hibernate.format_sql", "true",
                        "hibernate.hbm2ddl.auto", "update"
                        ))
                .persistenceUnit("mysql")
                .build();
    }

    @Bean(name = "postgresEntityManagerFactoryBean")
    public LocalContainerEntityManagerFactoryBean postgresEntityManagerFactoryBean(
            EntityManagerFactoryBuilder builder, @Qualifier("postgresDatasource") DataSource dataSource
    ) {
        return builder.dataSource(dataSource)
                .packages("com.example.multidb.postgres.entity")
                .properties(Map.of("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect",
                        "hibernate.show_sql", "true",
                        "hibernate.format_sql", "true",
                        "hibernate.hbm2ddl.auto", "update"
                ))
                .persistenceUnit("postgres")
                .build();
    }

    @Bean(name = "mysqlPlatformTransactionManager")
    public PlatformTransactionManager mysqlPlatformTransactionManager(
            @Qualifier("mysqlEntityManagerFactoryBean") EntityManagerFactory
                    factory) {
        return new JpaTransactionManager(factory);
    }

    @Bean(name = "postgresPlatformTransactionManager")
    public PlatformTransactionManager postgresPlatformTransactionManager(
            @Qualifier("postgresEntityManagerFactoryBean") EntityManagerFactory
                    factory) {
        return new JpaTransactionManager(factory);
    }
}
