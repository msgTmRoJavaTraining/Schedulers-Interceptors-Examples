package group.msg.examples.day13;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless
@Censored
@Interceptors(CensoredInterceptor.class)
public class CensoredBean {

    public String replaceString(String s){
        return s;
    }
}
