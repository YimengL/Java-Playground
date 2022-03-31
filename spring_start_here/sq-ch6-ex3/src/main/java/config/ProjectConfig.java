package config;

import aspects.LoggingAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
// We use @ComponentScan to tell Spring where to search for classes annotated with stereotype annotation.
@ComponentScan(basePackages = "services")
@EnableAspectJAutoProxy // Enables the aspects mechanism in our Spring app
public class ProjectConfig {

    /**
     * Adds an instance of the {@link LoggingAspect} class to the Spring context.
     */
    @Bean
    public LoggingAspect aspect() {
        return new LoggingAspect();
    }
}
