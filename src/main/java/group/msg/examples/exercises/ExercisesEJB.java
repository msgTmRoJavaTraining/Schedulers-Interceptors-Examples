package group.msg.examples.exercises;

import group.msg.examples.entities.Employee;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import java.util.logging.Logger;

@Stateless
public class ExercisesEJB {

    @Inject
    private Logger logger;

    @Interceptors(UpperCaseInterceptor.class)
    public Employee printEmployeeDetails(Employee emp) {
        return emp;
    }

}
