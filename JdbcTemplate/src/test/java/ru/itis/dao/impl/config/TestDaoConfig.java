package ru.itis.dao.impl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import ru.itis.dao.UsersDao;
import ru.itis.dao.impl.UsersDaoJdbcImpl;

import javax.sql.DataSource;

@Configuration
public class TestDaoConfig {

    @Bean
    UsersDaoJdbcImpl usersDao() {
        return new UsersDaoJdbcImpl(dataSource());
    }

    @Bean
    DataSource dataSource() {
        EmbeddedDatabase database =
                new EmbeddedDatabaseBuilder()
                        .setType(EmbeddedDatabaseType.H2)
                        .addScript("C:\\Users\\admin.WIN-IPM3OA3VQNQ\\Desktop\\JAVA\\11-502\\JdbcTemplate\\target\\classes\\ru.itis\\test.data\\scripts\\schema.sql")
                        .addScript("C:\\Users\\admin.WIN-IPM3OA3VQNQ\\Desktop\\JAVA\\11-502\\JdbcTemplate\\target\\classes\\ru.itis\\test.data\\scripts\\data.sql")
                        .build();
        return database;
    }
}
