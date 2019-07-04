package group.msg.examples.timer;

import javax.annotation.security.RunAs;
import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.interceptor.Interceptors;
import java.util.logging.Logger;

@RunAs("admin")
@Stateless
@Interceptors(SchedulerInterceptor.class)
public class ScheduledBean {

  @Inject
  private Logger logger;

  @Schedule(second = "*/30", minute = "*", hour = "*")
  public void scheduleWildCard() {
    logger.info("Executing scheduled wild card . . .");
  }

  @Schedules({@Schedule(second = "30/10", minute = "*/10", hour = "*/1")})
  public void scheduledIncrement() {
    logger.info("Executing scheduled increment . . .");
  }

  @Schedule(hour = "0-11", dayOfMonth = "15-31", dayOfWeek = "Mon-Fri", month = "1-6")
  public void scheduledRange() {
    logger.info("Executing scheduled range . . .");
  }

}
