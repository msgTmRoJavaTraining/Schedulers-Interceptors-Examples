package group.msg.test.employee;

import group.msg.examples.employee.Employee;
import group.msg.examples.employee.InterceptedEmployee;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import java.util.logging.Logger;

@RunWith(Arquillian.class)

public class EmployeeTest {
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "ISTExamples.war")
                .addPackages(true, "group.msg")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private InterceptedEmployee interceptedEmployee;

    @Inject
    private Logger logger;

    @Test
    public void testInterceptedEmployee() {

        Employee e1 = new Employee("Marius-Andrei");
        String response = interceptedEmployee.name(e1);
        logger.info("Employee name: " + response);
    }
}