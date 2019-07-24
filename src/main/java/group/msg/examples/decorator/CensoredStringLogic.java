package group.msg.examples.decorator;

import group.msg.examples.interceptor.CensoredStringClass;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.Random;


@Decorator
public abstract class CensoredStringLogic implements CensoredString
{
    @Inject
    @Delegate
    @Any
    private CensoredString censoredString;

    @Override
    public String censorOneString(String one) {

        return censoredString.censorOneString(one.replace("casa",returnRandomChar()));
    }

    public static String returnRandomChar()
    {
        Random r = new Random();

        String alphabet = "!@#$%^&*";
        return ""+alphabet.charAt(r.nextInt(alphabet.length()));
    }
}
