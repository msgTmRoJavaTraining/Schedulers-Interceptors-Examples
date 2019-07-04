package group.msg.examples.interceptor;

import javax.ejb.Stateless;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.ExcludeDefaultInterceptors;

@Stateless
@Audited
public class AuditedHello {

  public String hello(String param1) {
    return "Goodbye, privacy!\n";
  }

  @ExcludeClassInterceptors
  @ExcludeDefaultInterceptors
  public String doNotIntercept(int a, int b) {
    return "No one can control me . . .";
  }
}
