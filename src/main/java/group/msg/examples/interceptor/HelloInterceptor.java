package group.msg.examples.interceptor;

import javax.annotation.PostConstruct;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

@Priority(Interceptor.Priority.APPLICATION)
public class HelloInterceptor {

  @Inject
  private Logger logger;

  @PostConstruct
  public void interceptedInitialization(InvocationContext ic) throws Exception {
    logger.info("Intercepted initialization for bean: " + ic.getTarget());
    ic.proceed();
  }

  @AroundInvoke
  public Object interceptHello(InvocationContext ic) throws Exception {
    logger.info("Checking for method invocation: " + ic.getMethod().getName());

    Object result = ic.proceed();

    logger.info("Method result: " + result);

    return result;
  }
}
