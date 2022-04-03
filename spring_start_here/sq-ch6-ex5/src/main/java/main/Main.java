package main;

import config.ProjectConfig;
import model.Comment;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.CommentService;

import java.util.logging.Logger;

public class Main {

    private static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Gets the CommentService bean from the context
        var service = c.getBean(CommentService.class);

        // Creates a Comment instance to give as a parameter to the publishComment() method
        Comment comment = new Comment();
        comment.setText("Demo comment");
        comment.setAuthor("Natasha");

        // Calls the publishComment() method
       service.publishComment(comment);
       service.deleteComment(comment);
       service.editComment(comment);
    }
}
