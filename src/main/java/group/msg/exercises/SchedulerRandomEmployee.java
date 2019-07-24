package group.msg.exercises;

import group.msg.examples.timer.SchedulerInterceptor;

import javax.annotation.security.RunAs;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import java.util.Random;


@RunAs("admin")
@Stateless
@Interceptors(SchedulerInterceptor.class)
public class SchedulerRandomEmployee {

    @Schedule(minute = "*", hour = "*")
    public String scheduleCreateRandomEmployee() {
        String randomStr =  getAlphaNumericString(10);
        Random r = new Random();
        double randomValue = 5 + (12 - 5) * r.nextDouble();
        Employee e = new Employee(randomStr,randomValue);
        return e.toString();
    }
    private static String getAlphaNumericString(int n)
    {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }

}
