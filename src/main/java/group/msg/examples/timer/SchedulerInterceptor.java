package group.msg.examples.timer;

import javax.inject.Inject;
import javax.interceptor.AroundConstruct;
import javax.interceptor.AroundTimeout;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

public class SchedulerInterceptor {

  @Inject
  private Logger logger;

  @AroundTimeout
  public Object timeoutInterceptor(InvocationContext ic) throws Exception {
    logger.info("Around timeout for Scheduler method: " + ic.getMethod().getName());
    return ic.proceed();
  }

  @AroundConstruct
  public Object constructorInterceptor(InvocationContext ic) throws Exception {
    logger.info("Around construct for Scheduler!");
    return ic.proceed();
  }
}
