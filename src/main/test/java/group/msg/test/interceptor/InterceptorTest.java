package group.msg.test.interceptor;

import group.msg.examples.interceptor.AuditedHello;
import group.msg.examples.interceptor.InterceptedHello;
import group.msg.examples.interceptor.SecuredHello;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.logging.Logger;

@RunWith(Arquillian.class)
public class InterceptorTest {

  @Inject
  private InterceptedHello interceptedHello;

  @Inject
  private AuditedHello auditedHello;

  @Inject
  private SecuredHello securedHello;

  @Inject
  private Logger logger;


  @Deployment
  public static WebArchive createDeployment() {
    return ShrinkWrap.create(WebArchive.class, "ISTExamples.war")
            .addPackages(true, "group.msg")
            .addAsManifestResource("META-INF/beans.xml", "beans.xml");
  }

  @Test
  public void testInterceptedHello() {
    String response = interceptedHello.hello();
    logger.info("Intercepted hello: " + response);
    logger.info("================================================================");

    response = interceptedHello.doNotIntercept();
    logger.info("Not intercepted hello: " + response);
    logger.info("================================================================");
  }

  @Test
  public void testAuditedHello() {
    String response = auditedHello.hello("Nelule");
    logger.info("Audited hello: " + response);
    logger.info("================================================================");

    response = auditedHello.doNotIntercept(10, 20);
    logger.info("Not audited hello: " + response);
    logger.info("================================================================");
  }

  @Test
  public void testSecuredHello() {
    String response = securedHello.hello('z');
    logger.info("Secured hello: " + response);
    logger.info("================================================================");

    response = securedHello.doNotIntercept(15);
    logger.info("Not secured hello: " + response);
    logger.info("================================================================");
  }
}
