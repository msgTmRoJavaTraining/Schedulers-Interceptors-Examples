package group.msg.examples.timer;

import group.msg.examples.employee.Employee;
import group.msg.examples.employee.InterceptedEmployee;

import javax.annotation.security.RunAs;
import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

@RunAs("admin")
@Stateless

public class ScheduledEmployeeBean
{

    @Inject
    private Logger logger;

    @Inject
    private InterceptedEmployee interceptedEmployee;

    @Schedules({@Schedule(second ="59", minute = "*", hour = "*")})

    public void scheduledEmployeeGeneration() {
        logger.info("New employee");
        interceptedEmployee.name(new Employee(randomString()));
    }

    public static String randomString() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }
}
