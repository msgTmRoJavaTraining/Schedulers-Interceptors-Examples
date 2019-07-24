package group.msg.exercises;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.Arrays;
import java.util.logging.Logger;

@Priority(Interceptor.Priority.APPLICATION)
public class EmployeeInterceptor {

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object nameToUpperCase(InvocationContext ic) throws Exception {
        logger.info("Invoking: " + ic.getMethod().getName() + " with parameters: " + Arrays.toString(ic.getParameters()));
        Employee result = (Employee) ic.getParameters()[0];
            result.setName( result.getName().toUpperCase());
            Object []arr = new Object[]{result};
            ic.setParameters(arr);
        Object returnSomething = ic.proceed();
        logger.info("Method returned: " + returnSomething);

        return returnSomething;
    }
}
