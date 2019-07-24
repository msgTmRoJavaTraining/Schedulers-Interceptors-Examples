package group.msg.test.timer;

import group.msg.examples.exercises.RandomSchedulerCreator;
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
public class SchedulerTest {

  @Inject
  private ProgramaticTimerBean timerBean;

  @Inject
  private RandomSchedulerCreator randomSchedulerCreator;

  @Inject
  private Logger logger;


  @Deployment
  public static WebArchive createDeployment() {
    return ShrinkWrap.create(WebArchive.class, "ISTExamples.war")
            .addPackages(true, "group.msg");
  }

  @Test
  public void testTimerBean() {
    ScheduleExpression se = new ScheduleExpression();
    se.second("10").minute("*").hour("*");

    Assert.assertEquals(0, timerBean.getScheduledTimers().size());
    Assert.assertEquals(3, timerBean.getAllTimers().size());
    Date nextSchedule = timerBean.scheduleTimer(se);
    logger.info("Timer will be executed at: " + nextSchedule);
    Assert.assertEquals(1, timerBean.getScheduledTimers().size());
    Assert.assertEquals(4, timerBean.getAllTimers().size());

    String result = timerBean.stopScheduledTimers();
    logger.info(result);
    Assert.assertEquals(0, timerBean.getScheduledTimers().size());

    result = timerBean.stopAllScheduledTimers();
    logger.info(result);
    Assert.assertEquals(0, timerBean.getAllTimers().size());
  }

  @Test
  public void testRandomSchedulerCreator()
  {
    randomSchedulerCreator.scheduleNewEmployee();

  }
}
