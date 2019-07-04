package group.msg.examples.interceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.Arrays;
import java.util.logging.Logger;

@Audited
@Interceptor
public class AuditInterceptor {

  @Inject
  private Logger logger;

  @AroundInvoke
  public Object performAudit(InvocationContext ic) throws Exception {
    logger.info("Invoking: " + ic.getMethod().getName() + " with parameters: " + Arrays.toString(ic.getParameters()));

    Object result = ic.proceed();

    logger.info("Method returned result: " + result);

    return result;
  }
}
