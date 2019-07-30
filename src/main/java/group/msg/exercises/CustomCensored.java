package group.msg.exercises;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
@Censored
public class CustomCensored  {

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


    public String replaceSingleSwearWords(String received){
        String res = "";
        swearWords.add("fuck");
        for(String str:swearWords){

            res = received.replace(str,CustomCensored.getAlphaNumericString(str.length()));
        }

        return res;
    }

    public String replaceDoubleSwearWords(String firstReceived,String secondReceived){

        String res = "";
        swearWords.add("drg");

        String receivedConcat = firstReceived + secondReceived;

        for(String str:swearWords){

            res = receivedConcat.replace(str,CustomCensored.getAlphaNumericString(str.length()));
        }

        return res;
    }
}
