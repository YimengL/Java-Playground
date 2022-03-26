package proxies;

import model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


/**
 * The class implements the {@link CommentNotificationProxy} interface
 */
@Component
@Qualifier("PUSH") // Using @Qualifier, we name this implementation "PUSH"
public class CommentPushNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending push notification for comment: " + comment.getText());
    }
}
