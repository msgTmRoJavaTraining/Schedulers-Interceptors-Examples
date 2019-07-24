package group.msg.exercises;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.Arrays;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Priority(Interceptor.Priority.APPLICATION)
public class CensoredInterceptor {
    @Inject
    private Logger logger;
    public static String[] swearWords = {
            "f.*?u.*?k",
            "s.*?h.*?t",
            "bi.*?h",
            "as.*?s",
            "s.*?ck",
    };
    @AroundInvoke
    public Object censoredWordsTransformation(InvocationContext ic) throws Exception {
        String filterd= "";
        for(Object obj : ic.getParameters()){
            logger.info("Invoking: " + ic.getMethod().getName() + " with parameters: " + obj);
            filterd += filter(obj.toString());
        }
//        String []givenStrings= new String[]{};
//        String filterd= "";
//        for(int i =0 ; i< Arrays.toString(ic.getParameters()).length()-1; i++){
//            givenStrings[i]= (String) ic.getParameters()[i];
//            filterd += filter(givenStrings[i]);
//        }
        logger.info("Method returned: " + filterd);
        return filterd;
    }
    public static String filter(String in) {
        for (String swearWord : swearWords) {
            String stars;
            Pattern pat = Pattern.compile(swearWord, Pattern.CASE_INSENSITIVE);
            Matcher mat = pat.matcher(in);
            while (mat.find()) {
                char[] haha = new char[mat.end() - mat.start()];
                for (int i = 0; i < mat.end() - mat.start(); i++) {
                    haha[i] = '*';
                }
                stars = new String(haha);
                in = mat.replaceFirst(stars);
            }
        }
        return in;
    }
}
