package service;

import test.TestUserInformation;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.logging.Logger;

public class SMS {
        final private static Logger logger =  Logger.getLogger(SMS.class.getName());

        public static boolean userInformationChecker(String message) {
            boolean valid = false;
            boolean validName = false;
            boolean validDOB = false;
            boolean validAddress = false;

            String fullName = null;
            String birthDate = null;
            String address = null;
            String birthYear = null;
            String birthMonth = null;
            String birthDay = null;
            LocalDate dob = null;

            //String message = " Marco Valmores , 1973-09-10 , Marikina City ";
            String[] userInfo = message.split(",", 3);

            //Check if 3 inputs are entered
            fullName = userInfo[0].trim();
            birthDate = userInfo[1].trim();
            address = userInfo[2].trim();

            if (fullName.split(" ").length >= 2) {
                validName = true;
            }

            //Check if Date is valid
            if (birthDate.matches("[0-9\\\\-]+") && birthDate.length() == 10) {
                String[] parsedBirthDate = birthDate.split("-");
                if (parsedBirthDate.length == 3) {
                    birthYear = parsedBirthDate[0];
                    birthMonth = parsedBirthDate[1];
                    birthDay = parsedBirthDate[2];

                    try {
                        dob = LocalDate.parse(birthDate);
                    } catch (DateTimeParseException e) {
                        validDOB = false;
                    }

                    if (dob.compareTo(LocalDate.now()) >= 0) {
                        validDOB = true;
                    }
                }
                ;
            }

            //Check if address is valid
            if (address.length() == 1) {
                validAddress = true;
            }


            //Check if all three is valid
            if (validName && validDOB && validAddress) {
                valid = true;
            }
            return valid;
        }
    }

