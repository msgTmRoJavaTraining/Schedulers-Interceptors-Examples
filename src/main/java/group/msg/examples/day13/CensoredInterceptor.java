package group.msg.examples.day13;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Logger;

@Censored
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class CensoredInterceptor {
    @Inject
    private Logger logger;

    private String isBadWord(String givenWord) {
        logger.info("isBadWord reached!");
        String originalWord = givenWord;
        String[] badWords = { "urat1", "urat2", "urat3" };

        for (String badWord : badWords) {
            if (originalWord.equals(badWord)) {
                originalWord = generateHiddenBadWord(originalWord.length());
                return originalWord;
            }
        }

        return originalWord;
    }

    private String generateHiddenBadWord(int badWordLength) {
        String OPTIONS = "!@#$%^&*";
        StringBuilder newWord = new StringBuilder();
        Random rnd = new Random();

        while (newWord.length() < badWordLength) { // length of the random string.
            int index = (int) (rnd.nextFloat() * OPTIONS.length());
            newWord.append(OPTIONS.charAt(index));
        }

        return newWord.toString();
    }

    private String getRestoredMessage(String[] partedMessage) {
        StringBuilder restoredMessage = new StringBuilder();

        for (String s : partedMessage) {
            String temporaryString = s + " ";
            restoredMessage.append(temporaryString);
        }

        return restoredMessage.toString();
    }

    @AroundInvoke
    public Object performAudit(InvocationContext ic) throws Exception {
        logger.info("FirstInterceptor analizeaza metoda: " + ic.getMethod().getName());

        Object[] params = ic.getParameters();
        String message = (String) params[0];

        String[] partedMessage = message.split(" ");
        for(int i = 0; i < partedMessage.length; i++) {
            partedMessage[i] = isBadWord(partedMessage[i]);
        }

        Object[] newParam = { getRestoredMessage(partedMessage) };
        ic.setParameters(newParam);

        Object result = ic.proceed();

        return result;
    }
}
