package group.msg.test.day13;


import group.msg.examples.day13.CensoredBean;
import group.msg.examples.day13.Employee;
import group.msg.examples.day13.MyEJB;
import group.msg.examples.day13.MyScheduledBean;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.logging.Logger;

@RunWith(Arquillian.class)
public class MyTest {

    Employee e=new Employee("Ana","Manager");

    @Inject
    private MyEJB myEJB;

    @Inject
    private MyScheduledBean myScheduledBean;

    @Inject
    private CensoredBean censoredBean;

    @Inject
    private Logger logger;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "ISTExamples.war")
                .addPackages(true, "group.msg")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    @Test
    public void interceptedDetails(){
        String response=myEJB.printDetailsEmployee(e);
        logger.info("Employees name: " + response);
    }

    @Test
    public void randomDetails(){
        myScheduledBean.scheduleWildCard();
        logger.info("Employees name");
    }

    @Test
    public void censored(){
        String result=censoredBean.replaceString("shut the fuck up");
        logger.info("censored: " + result);

    }
}
