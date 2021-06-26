package ada.wm2.firstsb.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class JpaConfig {

/*
Commented for the demo of the property encoding

    @Bean
    public DataSource getH2DataSource()
    {
        return DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                .url("jdbc:h2:mem:dstestdb")
                .username("login")
                .password("psw")
                .build();
    }
 */

}