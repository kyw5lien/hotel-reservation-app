package testerclasses.other;

import helperclasses.EmailValidator;

public class EmailValidatorTester {
    public static void testEmailValidator(){
        String validEmail = "name@domain.com";
        String invalidEmail = "name@domain.org";

        System.out.println("\n" +"Test 1: EmailValidator:  ..." +"\n");
        System.out.println(validEmail +" valid? -> " +EmailValidator.isValid(validEmail));
        System.out.println(invalidEmail +" valid? -> " +EmailValidator.isValid(invalidEmail));

    }
}
