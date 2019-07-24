package group.msg.examples.interceptor;


import group.msg.examples.decorator.CensoredString;

import javax.ejb.Stateless;

@Stateless
public class CensoredStringClass implements CensoredString
{
    @Override
    public String censorOneString(String one) {
        return one;
    }

//    @Override
//    public String censoredTwoStrings(String one, String two) {
//        return one+two;
//    }
//    @Override
//    public String censoredThreeStrings(String one, String two, String three) {
//        return one+two+three;
//    }
}
