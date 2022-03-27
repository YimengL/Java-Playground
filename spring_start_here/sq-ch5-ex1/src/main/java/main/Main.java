package main;

import config.ProjectConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;


/**
 * A singleton bean. The app initialize the context when starting and adds a bean. In this case, we use the approach
 * with the {@code @Bean} annotation to declare the bean. The name of the method becomes the identifier of the bean.
 * Wherever you use that identifier, you get a reference to the same instance.
 */
public class Main {

    public static void main(String[] args) {
        // Creates the context
        var c = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        // These 2 lines refer to the same bean in the context. The two variables cs1 and cs2 contains a reference to
        // the same object instance. This is the reason b1 is true
        var cs1 = c.getBean("commentService", CommentService.class);
        var cs2 = c.getBean("commentService", CommentService.class);

        boolean b1 = cs1 == cs2;
        System.out.println(b1);
    }
}
