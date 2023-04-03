package model;

import helperclasses.EmailValidator;

import java.util.InputMismatchException;

/**
 *  Customer Account class: models information about the
 *  customer account and an e-mail validation.
 *
 * @author
 */
public class Customer {
    // Fields.
    private String firstName;
    private String lastName;
    private String email;

    // Constructors.
    public Customer() {
        // Empty constructor ...
    }

    /**
     * The constructor of the Customer Account class.
     * @param firstName the customer account's first name.
     * @param lastName the customer account's last name.
     * @param email the provided e-mail for the customer account.
     */
    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;

        if(EmailValidator.isValid(email))
            this.email = email;
    }

    // Getters.
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    // Setters.
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        if(EmailValidator.isValid(email)) {
            this.email = email;
        } else {
            throw new InputMismatchException();
        }
    }

    // toString Method.

    @Override
    public String toString() {
        return "Customer{" +
                "firstName:'" + firstName + '\'' +
                ", lastName:'" + lastName + '\'' +
                ", email:'" + email + '\'' +
                '}';
    }

    /**
     * Provides information about the Customer's account.
     * @return a String representing the Customer account's information.
     */
    /*
    @Override
    public String toString() {
        return "Customer " + "\n" +
                "\t" +"--------------------------------------" +
                "\n" +
                "\t" + "First Name: " + firstName + "\n" +
                "\t" + "Last Name: " + lastName + "\n" +
                "\t" + "E-mail: " + email + "\n";
    }
    */
}
