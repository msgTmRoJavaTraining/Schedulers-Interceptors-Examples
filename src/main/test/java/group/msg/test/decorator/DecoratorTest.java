package group.msg.test.decorator;

import group.msg.examples.decorator.BusinessLogic;
import group.msg.examples.decorator.DecoratorLogic;
import group.msg.examples.decorator.DelegateLogic;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class DecoratorTest {

  @Inject
  private BusinessLogic logic;

  @Deployment
  public static WebArchive createDeployment() {
    return ShrinkWrap.create(WebArchive.class, "ISTExamples.war")
            .addPackages(true, "group.msg")
            .addAsManifestResource("META-INF/beans.xml", "beans.xml");
  }

  @Test
  public void testDecoratorLogic() {
    Assert.assertEquals("Decorated business logic performed", logic.performSomeBusinessLogic());
    Assert.assertEquals("Other business logic performed", logic.performOtherBusinessLogic());
  }

}
