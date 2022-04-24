package com.example.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ProjectConfig {

    // The connection details are configurable, so it's a good idea to continue defining them outside of the source
    // code. In this example, we keep them in the "application.properties" file.
    @Value("${custom.datasource.url}")
    private String datasourceUrl;

    @Value("${custom.datasource.username}")
    private String datasourceUsername;

    @Value("${custom.datasource.password}")
    private String dataSourcePassword;

    /**
     * The method returns a {@link DataSource} object. If Spring Boot finds a {@link DataSource} already exists in the
     * Spring context it doesn't configure one.
     * @return  We return the {@link DataSource} instance, and Spring adds it to its context.
     */
    @Bean
    public DataSource dataSource() {
        // We'll use HikariCP as the data source implementation for this example. However, when you define the bean
        // yourself, you can choose other implementations if your project require something else.
        HikariDataSource dataSource = new HikariDataSource();
        // We set the connection parameters on the data source.
        dataSource.setJdbcUrl(datasourceUrl);
        dataSource.setUsername(datasourceUsername);
        dataSource.setPassword(dataSourcePassword);
        // You can configure other properties as well (eventually in certain conditions). In this case, I use the
        // connection timeout (how much time the data source waits for a connection before considering it can't get one)
        // as an example.
        dataSource.setConnectionTimeout(1000);

        return dataSource;
    }

}
