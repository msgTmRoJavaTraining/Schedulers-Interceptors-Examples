package group.msg.examples.timer;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Logger;

@Stateless
public class ProgramaticTimerBean {

  @Inject
  private Logger logger;

  @Resource
  private TimerService timerService;

  public Date scheduleTimer(ScheduleExpression se) {
    TimerConfig tc = new TimerConfig("Executing programmatic schedule . . .", true);
    Timer timer = timerService.createCalendarTimer(se, tc);

    return timer.getNextTimeout();
  }

  public String stopScheduledTimers() {
    StringBuilder result = new StringBuilder("Stopped timers that would have executed on: ");
    for(Timer timer : timerService.getTimers()) {
      result.append(result.toString().endsWith(": ") ? "" : ", ");
      result.append(timer.getNextTimeout());
      timer.cancel();
    }

    return result.toString();
  }

  public Collection<Timer> getScheduledTimers() {
    return timerService.getTimers();
  }

  public String stopAllScheduledTimers() {
    StringBuilder result = new StringBuilder("Stopped timers that would have executed on: ");
    for(Timer timer : timerService.getAllTimers()) {
      result.append(result.toString().endsWith(": ") ? "" : ", ");
      result.append(timer.getNextTimeout());
      timer.cancel();
    }

    return result.toString();
  }

  public Collection<Timer> getAllTimers() {
    return timerService.getAllTimers();
  }

  @Timeout
  public void programaticSchedule(Timer timer) {
    Serializable info = timer.getInfo();
    logger.info("Timer: " + timer + " " + info);
  }
}
