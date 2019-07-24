package group.msg.exercises;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundTimeout;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.Random;
import java.util.logging.Logger;

@Priority(Interceptor.Priority.APPLICATION)
public class ScheduleRandomEmployeeInterceptor {
    @Inject
    private Logger logger;

    @AroundTimeout
    public Object timeoutInterceptorEmployee(InvocationContext ic) throws Exception {
        String randomStr =  getAlphaNumericString(10);
        Random r = new Random();
        double randomValue = 5 + (12 - 5) * r.nextDouble();
        Employee e = new Employee(randomStr,randomValue);
        logger.info("Method returned: " + e.toString());

        return  e.toString();
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
