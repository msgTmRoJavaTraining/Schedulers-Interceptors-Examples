package group.msg.examples.interceptor;

import javax.ejb.Stateless;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.ExcludeDefaultInterceptors;

@Stateless
@Secured
public class SecuredHello {

  public String hello(char a) {
    return "Goodbye, privacy!\n";
  }

  @ExcludeClassInterceptors
  @ExcludeDefaultInterceptors
  public String doNotIntercept(double b) {
    return "No one can control me . . .";
  }
}
