package group.msg.exercises;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

public class ScheduleInterceptor {
    @Inject
    private Logger logger;

    @AroundInvoke
    public Object interceptObj(InvocationContext ic) throws Exception {
        Object result=ic.proceed();
        logger.info(((Employee)result).getName()+" "+((Employee) result).getAge());



        return result;
    }
}
