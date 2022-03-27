package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

public class Main {

    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Gets references from the context for the service beans
        var s1 = c.getBean(CommentService.class);
        var s2 = c.getBean(CommentService.class);

        // Compares the references for the injected CommentRepository instances. Because CommentRepository is
        // a prototype bean, the result of the comparison is always false.
        boolean b = s1.getCommentRepository() == s2.getCommentRepository();

        System.out.println(b);
    }
}
