package group.msg.examples.interceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

@Secured
@Interceptor
public class SecuredInterceptor {

  @Inject
  private Logger logger;

  @AroundInvoke
  public Object performSecurity(InvocationContext ic) {
    logger.info("You are not allowed to say hello!!!");
    return "User not authorized!";
  }
}
