package group.msg.exercises;

import group.msg.examples.interceptor.AuditedHello;
import group.msg.examples.interceptor.InterceptedHello;
import group.msg.examples.interceptor.SecuredHello;
import group.msg.examples.timer.ProgramaticTimerBean;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.ScheduleExpression;
import javax.inject.Inject;
import java.util.Date;
import java.util.logging.Logger;

@RunWith(Arquillian.class)
public class SchedulerEmployeeTest {

    @Inject
    private ScheduledEmployeeBean emp;
    @Inject
    private Logger logger;


    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "ISTExamples.war")
                .addPackages(true, "group.msg");
    }

    @Test
    public void scheduleEmployee() {
        emp.scheduleWildCard();
        logger.info("Intercepted hello: " );
        logger.info("================================================================");
    }
}

