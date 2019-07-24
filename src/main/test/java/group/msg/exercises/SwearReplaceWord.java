package group.msg.exercises;



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
public class SwearReplaceWord {

    @Inject
    private CustomCensored censoredEjb;

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
        String response = censoredEjb.replaceSwearWords("fuckkkkk");
        logger.info("Intercepted: " + response);
        logger.info("================================================================");


    }


}

