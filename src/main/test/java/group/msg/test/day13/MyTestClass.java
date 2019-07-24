package group.msg.test.day13;

import group.msg.examples.day13.Employee;
import group.msg.examples.day13.FirstExercise;
import group.msg.examples.day13.SecondExercise;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.logging.Logger;

@RunWith(Arquillian.class)
public class MyTestClass {
    @Inject
    private FirstExercise firstExercise;

//    @Inject
//    private SecondExercise secondExercise;

    @Inject
    private Logger logger;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "ISTExamples.war")
                .addPackages(true, "group.msg")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @Test
    public void testInterceptedSingleEmployeeGen() {
        String response = firstExercise.getEmployeeNameForIntercept(new Employee("Astanei Andrei", "KFC"));
        logger.info("Intercepted first exercise: " + response);
        logger.info("================================================================");
    }

//    @Test
//    public void testInterceptedScheduledEmployeeGen() {
//        secondExercise.scheduledEmployeeGeneration();
//        logger.info("Second Exercise Intercepted");
//        logger.info("================================================================");
//    }
}
