package group.msg.examples.exercises;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import java.util.logging.Logger;

@Interceptors(SwearInterceptor.class)
@Censored
@Stateless
public class NoSwearEJB {

    @Inject
    Logger logger;

    public String CensorString(String text) {
        logger.info("Result(Back in EJB): "+text);
        return text;
    }

}
