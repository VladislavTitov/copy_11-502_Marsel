package ru.itis.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.UrlResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ru.itis.controllers.UsersController;

import javax.sql.DataSource;
import java.net.MalformedURLException;

@Configuration
@ComponentScan("ru.itis")
@PropertySource("classpath:/ru.itis/db.properties")
public class SpringConfig {

    @Autowired
    Environment environment;

    @Bean
    public SessionFactory sessionFactory() {
        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource());
        builder.addResource("\\ru.itis\\hibernate\\User.hbm.xml");
        builder.addResource("\\ru.itis\\hibernate\\Auto.hbm.xml");
        builder.setProperty("hibernate.dialect","org.hibernate.dialect.PostgreSQL82Dialect");
        return builder.buildSessionFactory();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.driver"));
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.username"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));

        return dataSource;
    }

    @Bean
    public ViewResolver viewResolver() {
        return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
    }

    @Bean(name = "/show-user")
    public Controller getShowUserController() {
        return new UsersController();
    }
}
