package group.msg.test.day13;


import group.msg.examples.day13.Employee;
import group.msg.examples.day13.MyEJB;
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
}
