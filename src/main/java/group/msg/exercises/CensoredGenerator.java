package group.msg.exercises;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Censored
@Stateless
@Interceptors(CensoredInterceptor.class)
public class CensoredGenerator {
    public String censoredWords(String ... string) {
        return string.toString();
    }
}
