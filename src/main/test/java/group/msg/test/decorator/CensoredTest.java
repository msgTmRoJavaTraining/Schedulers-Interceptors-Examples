package group.msg.test.decorator;
import group.msg.examples.decorator.CensoredString;
import group.msg.examples.interceptor.CensoredStringClass;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.logging.Logger;

@RunWith(Arquillian.class)
public class CensoredTest
{
    @Inject
    private CensoredString censoredString;

    @Inject
    private Logger logger;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "ISTExamples.war")
                .addPackages(true, "group.msg")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    @Test
    public void testDecoratorLogic() {

        logger.info(censoredString.censorOneString("am o casa mare si frumoasa"));
    }
}