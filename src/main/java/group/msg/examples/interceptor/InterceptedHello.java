package group.msg.examples.interceptor;

import javax.ejb.Stateless;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.ExcludeDefaultInterceptors;
import javax.interceptor.Interceptors;

@Stateless
@Interceptors(HelloInterceptor.class)
public class InterceptedHello {

  public String hello() {
    return "Goodbye, privacy!\n";
  }

  @ExcludeClassInterceptors
  @ExcludeDefaultInterceptors
  public String doNotIntercept() {
    return "No one can control me . . .";
  }
}
