package helperclasses;

import java.util.regex.Pattern;

/**
 *  An E-mail Validator class.
 * @author
 */
public class EmailValidator {
    private static String emailRegEx = "^(.+)@(.+).com$";
    private static Pattern pattern = Pattern.compile(emailRegEx);

    /**
     * Checks if the e-mail provided is in the correct format (i.e., name@domain).
     * @param email the e-mail to be checked.
     * @return true if the e-mail provided is in the correct format; false if otherwise.
     * @author
     */
    public static boolean isValid(String email) {
        return pattern.matcher(email).matches();
    }

    public static String getEmailRegEx() {
        return emailRegEx;
    }

    public static Pattern getPattern(){
        return Pattern.compile(emailRegEx);
    }
}
