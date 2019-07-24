package group.msg.examples.exercises;

import group.msg.examples.entities.Employee;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
public class ExercisesEJB {

    @Interceptors(UpperCaseInterceptor.class)
    public Employee printEmployeeDetails(Employee emp) {
        return emp;
    }

}
