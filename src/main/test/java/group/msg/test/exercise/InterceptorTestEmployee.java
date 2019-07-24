package group.msg.test.exercise;

import group.msg.exercises.CensoredGenerator;
import group.msg.exercises.Employee;
import group.msg.exercises.Printer;
import group.msg.exercises.SchedulerRandomEmployee;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.logging.Logger;

@RunWith(Arquillian.class)
public class InterceptorTestEmployee {


    @Inject
    private Logger logger;

    @Inject
    private Printer print;

    @Inject
    private SchedulerRandomEmployee sre;

    @Inject
    private CensoredGenerator cg;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "ISTExamples.war")
                .addPackages(true, "group.msg")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    @Test
    public void testEmployeeData() {
        Employee e = new Employee("someone",1232.34);
        String result = print.printEmployeeData(e);
        logger.info("Intercepted: " + result );
        logger.info("================================================================");

    }
    @Test
    public void testSchedulerRandomEmployee() {
        sre.scheduleCreateRandomEmployee();
        logger.info("Random generated employee is : " );
        logger.info("================================================================");
    }
    @Test
    public void testCensored() {
        String result = cg.censoredWords("fuck","shit","ass");
        logger.info("================================================================");
    }
}
