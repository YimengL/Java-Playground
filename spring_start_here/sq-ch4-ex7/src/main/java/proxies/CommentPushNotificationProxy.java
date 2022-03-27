package proxies;

import model.Comment;
import org.springframework.stereotype.Component;


/**
 * The class implements the {@link CommentNotificationProxy} interface
 */
@Component
public class CommentPushNotificationProxy implements CommentNotificationProxy {

    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending push notification for comment: " + comment.getText());
    }
}
