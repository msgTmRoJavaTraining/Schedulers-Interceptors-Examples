package group.msg.exercises;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;


public class EmployeeInterceptor {
    @Inject
    private Logger logger;


    @AroundInvoke
    public Object interceptedEmplo(InvocationContext ic) throws Exception {
        Object empl=ic.proceed();
        ((Employee)empl).setName(((Employee) empl).getName().toUpperCase());
            logger.info(((Employee) empl).getName()+" "+ ((Employee) empl).getAge());
            return empl;
    }

}
