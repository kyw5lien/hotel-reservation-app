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
     * Checks if the e-mail provided matches the RegEx (i.e., name@domain.com).
     * @param email the e-mail to be matched.
     * @return true if the e-mail provided matches the RegEx; false if otherwise.
     * @author kyw5lien
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
