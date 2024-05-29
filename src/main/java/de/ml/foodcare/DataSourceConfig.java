package de.ml.foodcare;


import javax.sql.*;
import org.springframework.boot.jdbc.*;
import org.springframework.context.annotation.*;


/**
 *
 * @author javafish
 */
@Configuration
public class DataSourceConfig {
    
    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder
            .create()
            .url("jdbc:mysql://localhost/foodcare")
            .username("root")
            .password("cyBerMog12@")
            .build();
    }
    
}
