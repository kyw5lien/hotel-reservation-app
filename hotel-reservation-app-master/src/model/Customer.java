package model;

import helperclasses.EmailValidator;
import java.util.InputMismatchException;

/**
 *  Customer Account class: models information on a Hotel Customer Account; validating the customer account's e-mail included.
 * @author kyw5lien
 */
public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    
    /**
     * The constructor of the Customer Account class.
     *
     * @param firstName the customer account's first name.
     * @param lastName  the customer account's last name.
     * @param email     the provided e-mail for the customer account.
     */
    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (EmailValidator.isValid(email))
            this.email = email;
    }
    /**
     * Provides information on the Customer's account.
     * @return a String representing the Customer account's information.
     */
    @Override
    public String toString() {
        return "Customer{" +
                "firstName:'" + firstName + '\'' +
                ", lastName:'" + lastName + '\'' +
                ", email:'" + email + '\'' +
                '}';
    }
}
