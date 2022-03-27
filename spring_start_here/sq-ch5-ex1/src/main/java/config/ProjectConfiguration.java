package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import services.CommentService;

// The @Configuration annotation marks the configuration class.
@Configuration
public class ProjectConfiguration {

    // Adds the CommentService bean to the Spring context
    @Bean
    public CommentService commentService() {
        return new CommentService();
    }
}
