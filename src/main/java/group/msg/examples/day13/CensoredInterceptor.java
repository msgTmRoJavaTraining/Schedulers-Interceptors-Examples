package group.msg.examples.day13;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.Arrays;
import java.util.logging.Logger;

@Censored
@Interceptor
public class CensoredInterceptor {
    @Inject
    private Logger logger;

    @AroundInvoke
    public Object performAudit(InvocationContext ic) throws Exception {
        logger.info("FirstInterceptor analizeaza metoda: " + ic.getMethod().getName());

//        Object[] params = ic.getParameters();
//        String message = (String) params[0];

        Object result = ic.proceed();

        return result;
    }
}
