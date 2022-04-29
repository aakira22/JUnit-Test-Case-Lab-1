package test;

import org.junit.Test;
import service.SMS;
import service.SmsRegister;

import java.util.logging.Logger;

import static org.junit.Assert.*;

public class TestUserInformation {

    //String message = " Marco Valmores , 1973-09-10 , Marikina City ";

    @Test
    public void testNotNull () {
        String message = "";
        boolean result = SMS.userInformationChecker(message);
        //assertNotNull(message);
        assertFalse(result);
    }

}
