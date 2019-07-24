package group.msg.examples.day13;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import java.util.logging.Logger;

@Stateless
@Interceptors(FirstInterceptor.class)
public class FirstExercise {
    @Inject
    private Logger logger;

    public String getEmployeeNameForIntercept(Employee emp) {
        logger.info("Method result: " + emp.toString());
        return emp.toString();
    }
}
