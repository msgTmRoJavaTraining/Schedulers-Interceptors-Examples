package group.msg.examples.day13;

import javax.annotation.security.RunAs;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

@RunAs("admin")
@Stateless
public class SecondExercise {
    @Inject
    private Logger logger;

    @Inject
    private FirstExercise firstExercise;

    @Schedule(second = "0", minute = "*", hour = "*")
    public void scheduledEmployeeGeneration() {
        logger.info("Se executa crearea automata a unui nou angajat ...\nPuuff, angajat nou creat");

        firstExercise.getEmployeeNameForIntercept(new Employee(generateString(10), generateString(10)));
    }

    public String generateString(int StringLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'

        Random random = new Random();
        StringBuilder buffer = new StringBuilder(StringLength);

        for (int i = 0; i < StringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }

        return buffer.toString();
    }
}
