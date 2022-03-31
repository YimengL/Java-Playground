package services;

import aspects.ToLog;
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
    public void publishComment(Comment comment) {
        logger.info("Publishing comment: " + comment.getText());
    }


    /**
     * We use the custom annotation for the methods we want the aspect to intercept
     */
    @ToLog
    public void deleteComment(Comment comment) {
        logger.info("Deleting comment: " + comment.getText());
    }


    public void editComment(Comment comment) {
        logger.info("Editing comment: " + comment.getText());
    }
}
