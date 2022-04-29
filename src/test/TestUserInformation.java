package test;

import org.junit.Test;
import service.SMS;
import static org.junit.Assert.*;

public class TestUserInformation {

    //String message = " Marco Valmores , 1973-09-10 , Marikina City ";

    @Test
    public void testEmptyString() {
        String message = "";
        boolean result = SMS.userInformationChecker(message);
        assertNotNull(message);
        assertFalse(result);
    }

    @Test
    public void testNotNull() {
        String message = "";
        boolean result = SMS.userInformationChecker(message);
        assertNotNull(message);
        assertFalse(result);
    }

    @Test
    public void testNormal() {
        String message = "Marco Valmores , 1973-09-10 , Marikina City";
        boolean result = SMS.userInformationChecker(message);
        assertTrue(result);
    }

    @Test
    public void testTwoInput() {
        String message = " 1973-09-10 , Marikina City";
        boolean result = SMS.userInformationChecker(message);
        assertFalse(result);
    }

    @Test
    public void testScrambledOrder() {
        String message = " 1973-09-10 , Marco Valmores ,Marikina City";
        boolean result = SMS.userInformationChecker(message);
        assertFalse(result);
    }


    @Test
    public void testDetailedAddress() {
        String message = "Marco Valmores , 1973-09-10 , 123 Bldg, EDSA Blvd., NCR, PH";
        boolean result = SMS.userInformationChecker(message);
        assertTrue(result);
    }

    @Test
    public void testDetailedAddressScrambledOrder() {
        String message = "Marco Valmores , 123 Bldg, EDSA Blvd., NCR, PH, 1973-09-10 , ";
        boolean result = SMS.userInformationChecker(message);
        assertFalse(result);
    }

    @Test
    public void testWrongDate() {
        String message = "Marco Valmores , 09-10-1973 , Marikina City";
        boolean result = SMS.userInformationChecker(message);
        assertFalse(result);
    }

    @Test
    public void testDateEmpty() {
        String message = "Marco Valmores , 1973--10 , Marikina City";
        boolean result = SMS.userInformationChecker(message);
        assertFalse(result);
    }

}
