package group.msg.exercises;

import group.msg.examples.timer.SchedulerInterceptor;

import javax.annotation.security.RunAs;
import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import java.util.logging.Logger;

@RunAs("admin")
@Stateless
@Interceptors(SchedulerEmployeeInterceptor.class)
public class ScheduledEmployeeBean {



        @Inject
        private Logger logger;

        @Schedule(second = "*", minute = "*/1", hour = "*")
        public void scheduleWildCard() {

            String name = RandomString.getAlphaNumericString(10);
            String cnp = RandomString.getAlphaNumericString(10);
            int age = (int)Math.random();
            Employee emp = new Employee(name,cnp,age);
        logger.info("Executing method"+"Nume:"+emp.getName()+" CNP:"+emp.getCnp()+" AGE:"+emp.getAge());


    }



    }
