package group.msg.examples.day13;

import javax.annotation.PostConstruct;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.lang.reflect.Parameter;
import java.util.logging.Logger;

@Priority(Interceptor.Priority.APPLICATION)
public class FirstInterceptor {
    @Inject
    private Logger logger;

    @PostConstruct
    public void interceptedInitialization(InvocationContext ic) throws Exception {
        logger.info("Se apeleaza FirstInterceptor pentru - " + ic.getTarget());
        ic.proceed();
    }

    @AroundInvoke
    public Object interceptEmployeeData(InvocationContext ic) throws Exception {
        logger.info("FirstInterceptor analizeaza metoda: " + ic.getMethod().getName());

        Object[] params = ic.getParameters();
        Employee emp = (Employee) params[0];

        emp.setName(emp.getName().toUpperCase());

        Object[] newParams = { emp };
        ic.setParameters(newParams);

        Object result = ic.proceed();

        return result;
    }
}
