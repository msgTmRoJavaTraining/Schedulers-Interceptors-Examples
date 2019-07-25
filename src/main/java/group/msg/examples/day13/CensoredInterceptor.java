package group.msg.examples.day13;


import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Logger;

@Censored
@Interceptor
public class CensoredInterceptor {

     String characters = "!@#$%^&*";
     String swearWords = "shit fuck stupid idiot";


    @Inject
    private Logger logger;

    @Inject
    private CensoredBean censoredBean;

    @AroundInvoke
    public Object censored(InvocationContext ic) throws Exception {


        logger.info("Invoking: " + ic.getMethod().getName() + " with parameters: " + Arrays.toString(ic.getParameters()));

        StringBuilder censoredText= new StringBuilder();

        Object[] params =ic.getParameters();
        String string = (String) params[0];

        String[] splitSwearWords= swearWords.split(" ");
        String[] splitString = string.split(" ");

        for (String swear: splitSwearWords) {
            for (String str: splitString) {
                if(str.contains(swear))
                {
                    censoredText.append(string.replace(str, generateAlphabeticalString(new Random(), str.length())));
                    logger.info("Result(in Interceptor): "+censoredText);
                }
            }
        }
        Object[] obj = new Object[] {censoredText.toString()};
        ic.setParameters(obj);
        Object result = ic.proceed();

        return result;
    }


    private String generateAlphabeticalString(Random random, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = characters.charAt(random.nextInt(characters.length()));
        }
       return new String(text);
    }
}
