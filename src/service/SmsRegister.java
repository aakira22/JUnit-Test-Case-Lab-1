package service;

import java.util.Locale;

public class SmsRegister {

    public static boolean smsRegisterChecker(String message){
        boolean valid = false;

        //Removes whitespace before and after the keyword
        //then accepts lowercase and uppercase characters
        if (message.trim().equalsIgnoreCase("register")){
            valid = true;
        }

        return valid;
    }
}
