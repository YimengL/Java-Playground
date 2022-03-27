package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        // This app creates the Spring context, but it doesn't use the CommentService bean anywhere
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);
    }
}
