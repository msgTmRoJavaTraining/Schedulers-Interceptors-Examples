package group.msg.examples.day13;

import javax.ejb.Stateless;

@Stateless
@Censored
public class ThirdExercise {
    public String sendMessageToChat(String message) {
        return message;
    }
}
