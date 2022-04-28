package service;

import java.util.HashMap;

public class SMS {

    public static boolean userInformationCheck(HashMap<String,String> sms) {

        boolean valid = false;

        String message = sms.get("Message");
        String[] userInformation = message.split(",");

        //to continue

    }

}
