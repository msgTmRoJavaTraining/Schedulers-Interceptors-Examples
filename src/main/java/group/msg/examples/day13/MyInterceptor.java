package group.msg.examples.day13;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.lang.reflect.Parameter;
import java.util.logging.Logger;
@Interceptor
public class MyInterceptor {

    @Inject
    private Logger logger;

    @PostConstruct
    public void interceptedInitialization(InvocationContext ic) throws Exception {
        logger.info("Intercepted details " + ic.getTarget());
        ic.proceed();
    }

    @AroundInvoke
    public Object interceptDetails(InvocationContext ic) throws Exception {
        logger.info("Checking for method invocation: " + ic.getMethod().getName());

        Object[] param=ic.getParameters();
        Employee e= (Employee) param[0];
        e.setName(e.getName().toUpperCase());

        ic.setParameters(param);

        Object result = ic.proceed();

        logger.info("Method result: " + result);

        return result;
    }
}
