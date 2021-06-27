package com.hw2.blog.config;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class JPAConfig {

    // uncomment @Primary if you wanna use H2 DB;
    @Bean
//    @Primary
    public DataSource getH2DataSource(){
        return DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:mem:testdb")
                .username("admin")
                .password("admin")
                .build();
    }

    @Bean
//    @Primary  // comment it if you use any other data source
    public DataSource getGlobalPostgresDataSource(){
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://ec2-35-170-85-206.compute-1.amazonaws.com:5432/dc6q0hpqh57evt?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory")
                .username("atncyyknlauoph")
                .password("432e947acaa05a9928e33de753e88d4a1feafa27d60f1e55918583ab0e577890")
                .build();
    }

    // un comment primary in order to user your local postgres db.
    @Bean
    @Primary
    DataSource getPostgresDataSource(){
        return DataSourceBuilder.create()
                .driverClassName("org.postgresql.Driver")
                .url("jdbc:postgresql://localhost:5432/studentdb")
                .username("feqanrasulov")
                .password("F5566041f")
                .build();
    }

}
