package aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;


@Aspect
public class LoggingAspect {

    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    // Defines which are intercepted method
    // Optionally, when you use @AfterReturning, you can get the value returned by the intercepted method. In this case,
    // we add the "returning" attribute with a value that corresponds to the name of the method's parameter where this
    // will be provided
    @AfterReturning(value = "@annotation(ToLog)", returning = "returnedValue")
    public void log(Object returnedValue) {
        logger.info("Method executed and returned " + returnedValue);
    }

}
