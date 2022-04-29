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


            //Check if 3 inputs are entered
            try {
                String[] userInfo = message.split(",", 3);
                fullName = userInfo[0].trim();
                birthDate = userInfo[1].trim();
                address = userInfo[2].trim();

            } catch (Exception e){
                return valid;
            }

            //Check if Full Name is valid with First and Last name
            if (fullName.split(" ").length >= 2) {
                validName = true;
            }

            //Check if Date is valid
            //Check if birthdate input is only digits and "-" character and if length is 10 (yyyy-mm-dd)
                if (birthDate.matches("[0-9\\\\-]+") && birthDate.length() == 10) {
                    String[] parsedBirthDate = birthDate.split("-");
                    if (parsedBirthDate.length == 3) {
                        birthYear = parsedBirthDate[0];
                        birthMonth = parsedBirthDate[1];
                        birthDay = parsedBirthDate[2];

                        try {

                        //parse of date to yyyy-mm-dd
                        dob = LocalDate.parse(birthDate);

                        //check if input date is not a future date
                        if (dob.compareTo(LocalDate.now()) <= 0 && dob.compareTo(LocalDate.now()) >= -122) {
                            validDOB = true;
                        }

                        } catch (DateTimeParseException e) {
                                        validDOB = false;
                                    }

                    }
                }


            //Check if address is valid(e.g. not empty string)
            if (address.length() >= 1) {
                validAddress = true;
            }

            //Check if all three is valid
            if (validName && validDOB && validAddress) {
                valid = true;
            }

            return valid;
        }
    }

