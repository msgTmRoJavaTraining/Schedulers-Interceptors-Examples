package group.msg.exercises;

import org.eclipse.persistence.annotations.ClassExtractor;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

@Censored
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
            String []arr = (String [])obj;
            for(String s:arr){
                filterd = "";
                logger.info("Invoking: " + ic.getMethod().getName() + " with parameters: " + s);
                filterd = filter(s);
                logger.info("Method returned: " + filterd);
            }
        }
        return filterd;
    }
    public static String filter(String given) {
        int nrOfChars = given.length();
       String result=  getAlphaNumericString(nrOfChars);
       return result;
    }
    private static String getAlphaNumericString(int n)
    {
        String AlphaNumericString = "!@#$%^&*";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }
}
