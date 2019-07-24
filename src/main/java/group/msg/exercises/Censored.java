package group.msg.exercises;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Censored {
    @Inject
    private Logger logger;

    @AroundInvoke
    public Object nameToUpperCase(InvocationContext ic) throws Exception {

        logger.info("Invoking: " + ic.getMethod().getName() + " with parameters: " + Arrays.toString(ic.getParameters()));
        List<String> givenStrings = new ArrayList<>();
        for(int i =0 ; i<ic.getParameters().length-1; i++){
            givenStrings.add((String) ic.getParameters()[i]);
        }
        result.setName( result.getName().toUpperCase());
        Object []arr = new Object[]{result};
        ic.setParameters(arr);
        Object returnSomething = ic.proceed();
        logger.info("Method returned: " + returnSomething);

        return returnSomething;
    }
}
