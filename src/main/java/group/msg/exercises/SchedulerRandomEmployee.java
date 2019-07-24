package group.msg.exercises;

import group.msg.examples.timer.SchedulerInterceptor;

import javax.annotation.security.RunAs;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import java.util.Random;
import java.util.logging.Logger;


@RunAs("admin")
@Stateless
@Interceptors(ScheduleRandomEmployeeInterceptor.class)
public class SchedulerRandomEmployee {
    @Inject
    private Logger logger;

    @Schedule(minute = "*", hour = "*")
    public void scheduleCreateRandomEmployee() {
        logger.info("Do something");
    }


}
