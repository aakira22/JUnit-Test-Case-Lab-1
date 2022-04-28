package test;

import org.junit.Test;
import service.SmsRegister;
import static org.junit.Assert.*;

public class TestSmsRegister {

    @Test
    public void testNotNull () {
        String message = "";
        boolean result = SmsRegister.smsRegisterChecker(message);
        assertNotNull(message);
        assertFalse(result);
    }

    @Test
    public void testNormal() {
        String message = "register";
        boolean result = SmsRegister.smsRegisterChecker(message);
        assertTrue(result);
    }

    @Test
    public void testUppercase() {
        String message = "REGISTER";
        boolean result = SmsRegister.smsRegisterChecker(message);
        assertTrue(result);
    }

    @Test
    public void testUppercaseLowercase() {
        String message = "ReGiStEr";
        boolean result = SmsRegister.smsRegisterChecker(message);
        assertTrue(result);
    }

    @Test
    public void testFrontWhiteSpace() {
        String message = " register";
        boolean result = SmsRegister.smsRegisterChecker(message);
        assertTrue(result);
    }

    @Test
    public void testBackWhiteSpace() {
        String message = "register ";
        boolean result = SmsRegister.smsRegisterChecker(message);
        assertTrue(result);
    }

    @Test
    public void testInsideWhiteSpace() {
        String message = "re gister";
        boolean result = SmsRegister.smsRegisterChecker(message);
        assertFalse(result);
    }

    @Test
    public void testInsideWhiteSpaceMixed() {
        String message = " re gister";
        boolean result = SmsRegister.smsRegisterChecker(message);
        assertFalse(result);
    }

    //to add more cases
}
