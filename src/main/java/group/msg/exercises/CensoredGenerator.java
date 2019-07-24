package group.msg.exercises;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;


@Stateless
@Interceptors(CensoredInterceptor.class)
public class CensoredGenerator {
    public String censoredWords(String ... string) {
//        String output="";
//        for(String s:strings){
//            output = output + s;
//        }
//        return output;
        return "ssa";
    }
}
