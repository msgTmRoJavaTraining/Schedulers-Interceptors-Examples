package group.msg.exercises;

import java.util.ArrayList;
import java.util.List;


public class CustomCensored implements Censored {

    private static List<String> swearWords = new ArrayList<>();

    public static void addSwearWords(String str){
        swearWords.add(str);
    }

    static String getAlphaNumericString(int n) {

        // chose a Character random from this String
        String AlphaNumericString = "@#$%^&*";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }


    public String replaceSwearWords(String received){

        for(String str:swearWords){

            received.replace(received,str);
        }

        return received;
    }
}
