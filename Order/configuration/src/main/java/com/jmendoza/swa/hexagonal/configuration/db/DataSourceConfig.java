package com.jmendoza.swa.hexagonal.configuration.db;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.tomcat")
    public DataSource getDataSource(Environment env) {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        final Properties properties = new Properties();

        dataSource.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
        dataSource.setUrl(env.getProperty("spring.datasource.url"));
        dataSource.setUsername(env.getProperty("spring.datasource.username"));
        dataSource.setPassword(env.getProperty("spring.datasource.password"));

        properties.setProperty("initialSize", env.getProperty("spring.datasource.tomcat.initial-size"));
        properties.setProperty("minIdle", env.getProperty("spring.datasource.tomcat.min-idle"));
        properties.setProperty("maxActive", env.getProperty("spring.datasource.tomcat.max-active"));
        properties.setProperty("maxIdle", env.getProperty("spring.datasource.tomcat.max-idle"));
        properties.setProperty("minEvictableIdleTimeMillis", env.getProperty("spring.datasource.tomcat.min-evictable-idle-time-millis"));
        properties.setProperty("maxWait", env.getProperty("spring.datasource.tomcat.max-idle"));

        dataSource.setConnectionProperties(properties);

        return dataSource;
    }
}


