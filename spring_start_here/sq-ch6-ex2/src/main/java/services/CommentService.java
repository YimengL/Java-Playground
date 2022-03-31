package services;

import model.Comment;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


/**
 * We use the stereotype annotation to make this as a bean in the Spring context.
 */
@Service
public class CommentService {

    // To log a message in the app's console every time someone calls the use case, we use a logger object.
    private Logger logger = Logger.getLogger(CommentService.class.getPackageName());

    /**
     * This method defines the use case of our demonstration.
     */
    public String publishComment(Comment comment) {
        logger.info("Publishing comment: " + comment.getText());
        return "SUCCESS";
    }
}
