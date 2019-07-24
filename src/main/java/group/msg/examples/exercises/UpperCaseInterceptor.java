package group.msg.examples.exercises;

import group.msg.examples.entities.Employee;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

public class UpperCaseInterceptor {

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object interceptEmployee(InvocationContext ic) throws Exception {
        logger.info("Checking for method invocation: " + ic.getMethod().getName());


        Object result = ic.proceed();
        String upperName=((Employee)result).getName().toUpperCase();

        logger.info("Method result: " + upperName);
        return result;
    }
}
