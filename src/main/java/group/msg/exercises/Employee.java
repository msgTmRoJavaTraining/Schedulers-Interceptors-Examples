package group.msg.exercises;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Random;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Stateless
public class Employee {
    private String name;
    private int age;

    @Inject
    private EJB theEjb;

    public String displayName(){return this.name;}

    static String getAlphaNumericString()
    {
        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        // create StringBuffer size of AlphaNumericString
        Random rnd=new Random();
        int n=rnd.nextInt(10);
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());
            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }
    @Schedule(hour ="*",minute = "*",second = "*/10")
     public void randomEmpl(){
        Random rndAge=new Random();
        Employee rnd=new Employee();
        rnd.setName(Employee.getAlphaNumericString());
        rnd.setAge(rndAge.nextInt(100));
        theEjb.printEmploy(rnd);

    }
}
