package services;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy // The @Lazy annotation tells Spring that it needs to create the bean only when someone refers to the bean for the first time
public class CommentService {

    public CommentService() {
        System.out.println("CommentService instance created!");
    }
}
