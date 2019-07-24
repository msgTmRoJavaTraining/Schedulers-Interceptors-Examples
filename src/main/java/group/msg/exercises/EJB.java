package group.msg.exercises;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import java.util.Random;
import java.util.logging.Logger;

@Stateless
public class EJB {
    @Inject
    private Logger logger;


    @Interceptors(EmployeeInterceptor.class)
    public Employee loggThEeName(Employee emplo){
        logger.info(emplo.getName()+" "+emplo.getAge());
        return emplo;
    }

    @Interceptors(ScheduleInterceptor.class)
    public Employee printEmploy(Employee emp){
        return emp;
    }





}
