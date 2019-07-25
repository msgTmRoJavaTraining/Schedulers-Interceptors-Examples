package group.msg.examples.day13;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
@Censored
public class ThirdExercise {
    public String sendMessageToChat(String... message) {
        return displayArray(message);
    }

    private String displayArray(String... array) {
        StringBuilder stringBuilder = new StringBuilder();
        for(String s : array) {
            String temporaryString = s + "\n";
            stringBuilder.append(temporaryString);
        }

        return stringBuilder.toString();
    }
}

