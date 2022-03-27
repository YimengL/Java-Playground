package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;
import services.UserService;

public class Main {
    public static void main(String[] args) {
        // Creates the Spring context based on the configuration class
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Gets the references of the two service beans in the Spring context
        var s1 = c.getBean(CommentService.class);
        var s2 = c.getBean(UserService.class);

        // Compares the references for the repository dependency injected by Spring
        boolean b = s1.getCommentRepository() == s2.getCommentRepository();

        // Because the dependency (CommentRepository) in singleton, both services contain the same reference, so this
        // line always prints "true".
        System.out.println(b);

    }
}
