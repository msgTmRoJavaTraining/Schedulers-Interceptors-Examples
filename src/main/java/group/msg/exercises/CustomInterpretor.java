package group.msg.exercises;


import javax.enterprise.inject.Intercepted;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

@Censored
@Interceptor
public class CustomInterpretor {

    @Inject
    Logger logger;

    @AroundInvoke
    public Object performSecurity(InvocationContext ic) throws  Exception{
        logger.info("Checking for method invocation: " + ic.getMethod().getName());

        Object result = ic.proceed();

        logger.info("Method result: " + result);

        return result;
    }
}
