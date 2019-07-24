package group.msg.examples.employee;


import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
@Interceptors(InterceptedEmployee.class)
public class InterceptedEmployee
{
    public String name(Employee employee)
    {
       return employee.getName().toUpperCase();
    }
}
