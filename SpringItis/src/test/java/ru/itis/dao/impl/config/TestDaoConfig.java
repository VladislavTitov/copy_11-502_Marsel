package ru.itis.dao.impl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import ru.itis.dao.impl.jdbc.AutoDaoJdbcImpl;
import ru.itis.dao.impl.jdbc.UsersDaoJdbcImpl;

import javax.sql.DataSource;

@Configuration
public class TestDaoConfig {

    @Bean
    UsersDaoJdbcImpl usersDao() {
        return new UsersDaoJdbcImpl(dataSource());
    }

    @Bean
    AutoDaoJdbcImpl autoDao() {
        return new AutoDaoJdbcImpl(dataSource());
    }

    @Bean
    DataSource dataSource() {
        EmbeddedDatabase database =
                new EmbeddedDatabaseBuilder()
                        .setType(EmbeddedDatabaseType.H2)
                        .addScript("scripts\\schema.sql")
                        .addScript("scripts\\data.sql")
                        .build();
        return database;
    }
}
