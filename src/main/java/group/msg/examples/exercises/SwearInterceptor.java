package group.msg.examples.exercises;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.Objects;
import java.util.Random;
import java.util.logging.Logger;

public class SwearInterceptor {
    public static final String CHARACTERS = "!@#$%^&*";
    public static final String SWEARS = "fuck bastard idiot poor bitch";

    @Inject
    private Logger logger;

    @Inject
    private NoSwearEJB noSwearEJB;

    @AroundInvoke
    public Object interceptSwear(InvocationContext ic) throws Exception {

        String censoredText="";

        Object[] params =ic.getParameters();
        String text = ((String) params[0]);

        String[] swears_splituit= SWEARS.split(" ");
        String[] text_splituit = text.split(" ");

        for (String swear: swears_splituit
             ) {
            for (String str: text_splituit
            ) {
                if(str.contains(swear))
                {
                    censoredText+= text.replace(str,generateAlphabeticalString(new Random(), str.length()));
                    logger.info("Result(in Interceptor): "+censoredText);
                }
            }
        }
        Object[] asd = new Object[] {censoredText};
        ic.setParameters(asd);
        Object result = ic.proceed();
        return result;
    }

    private String generateAlphabeticalString(Random random, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = CHARACTERS.charAt(random.nextInt(CHARACTERS.length()));
        }
        return new String(text);
    }
}
