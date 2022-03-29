package services;

import model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import processors.CommentProcessor;

@Service
public class CommentService {

    @Autowired
    private ApplicationContext context;

    public void sendComment(Comment c) {
        // A new CommentProcessor instance is always provided here.
        CommentProcessor p = context.getBean(CommentProcessor.class);

        p.setComment(c);
        p.processComment(c);
        p.validateComment(c);

        c = p.getComment();
        // do something further
    }
}
