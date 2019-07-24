package group.msg.exercises;

import org.apache.derby.impl.jdbc.LOBInputStream;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import java.util.logging.Logger;

@Stateless
@Interceptors(EmployeeInterceptor.class)
public class Printer {
    @Inject
    private Logger logger;

    public String printEmployeeData(Employee e) {
       return e.toString();
    }
}
