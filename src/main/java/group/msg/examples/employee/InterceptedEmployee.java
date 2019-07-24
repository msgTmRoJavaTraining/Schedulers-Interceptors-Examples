package group.msg.examples.employee;


import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import java.util.logging.Logger;

@Stateless
@Interceptors(InterceptedEmployee.class)

public class InterceptedEmployee
{

    @Inject
    private Logger logger;


    public Employee name(Employee employee)
    {
       return employee;
    }
}
