package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// The @Configuration annotation marks the configuration class.
@Configuration
// We use the @ComponentScan annotation to tell Spring in which packages to search for the classes annotated with
// stereotype annotations. Observe that the model package is not specified because it doesn't contain classes annotated
// with stereotype annotations.
@ComponentScan(
        basePackages = {"proxies", "services", "repositories"}
)
public class ProjectConfiguration {
}
