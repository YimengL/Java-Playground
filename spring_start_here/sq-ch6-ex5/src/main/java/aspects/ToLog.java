package aspects;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME) // Enables the annotation to be intercepted at runtime
@Target(ElementType.METHOD)  // Restricts this annotation to only be used with methods
public @interface ToLog {
}
