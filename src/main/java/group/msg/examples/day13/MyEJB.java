package group.msg.examples.day13;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.interceptor.Interceptors;
import java.util.logging.Logger;


@Stateless
@Interceptors(MyInterceptor.class)
public class MyEJB {

    @Inject
    private Logger logger;

    public String printDetailsEmployee(Employee employee){
        logger.info("Name of the employee: " + employee.getName());
        return employee.getName();
    }
}
