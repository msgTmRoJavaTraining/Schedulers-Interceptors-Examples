package group.msg.examples.day13;

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

 public class MyScheduledBean {

    @Inject
    private Logger logger;

    @Inject
    private MyEJB myEJB;

    public String generateRandomField(){
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


    @Schedule(second = "*/10", minute = "*", hour = "*")
    public void scheduleWildCard() {
        logger.info("Executing scheduled wild card . . .");
        myEJB.printDetailsEmployee(new Employee(generateRandomField(),generateRandomField()));
    }




}