package group.msg.examples.exercises;

import group.msg.examples.entities.Employee;

import javax.ejb.*;
import javax.inject.Inject;
import java.util.Random;


@Stateless
public class RandomSchedulerCreator {
    public static final String LETTERS =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz ";

    @Inject
    ExercisesEJB exercisesEJB;

    @Schedule(second = "*/30", minute = "*", hour = "*")
    public void scheduleNewEmployee() {
        double rangeMin = 1000;
        double rangeMax = 10000;
        Random r = new Random();
        double randomDouble = rangeMin + (rangeMax - rangeMin) * r.nextDouble();

        int randomInt = r.nextInt(65 - 18) + 18;

        String randomString = generateAlphabeticalString(new Random(), 18);

        exercisesEJB.printEmployeeDetails(new Employee(randomString, randomInt, randomDouble));
    }

    private String generateAlphabeticalString(Random random, int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = RandomSchedulerCreator.LETTERS.charAt(random.nextInt(RandomSchedulerCreator.LETTERS.length()));
        }
        return new String(text);
    }
}
