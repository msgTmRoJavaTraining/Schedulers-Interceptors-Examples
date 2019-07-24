package group.msg.exercises;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
@Interceptors(EmployeeInterceptor.class)
public class EmployeeEjb {

    public String printEmployee(Employee employee){ return employee.getName(); }
}
