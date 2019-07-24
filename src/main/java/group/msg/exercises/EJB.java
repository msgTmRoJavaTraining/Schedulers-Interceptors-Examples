package group.msg.exercises;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
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



}
