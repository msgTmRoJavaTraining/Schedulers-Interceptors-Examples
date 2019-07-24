package group.msg.test.employee;

import group.msg.examples.timer.ScheduledEmployeeBean;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.runner.RunWith;
import javax.inject.Inject;
import java.util.logging.Logger;

@RunWith(Arquillian.class)
public class EmployeeSchedulerTest
{


    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "ISTExamples.war")
                .addPackages(true, "group.msg");
    }

    @Inject
    private Logger logger;

    @Inject
    private ScheduledEmployeeBean scheduledEmployeeBean;

    public void testInterceptedScheduledEmployeeGen() {
        scheduledEmployeeBean.scheduledEmployeeGeneration();
        logger.info("Second Exercise Intercepted");
        logger.info("================================================================");
    }
}
