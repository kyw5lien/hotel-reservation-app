package model;

import helperclasses.EmailValidator;

/**
 *  Customer class: models information of a Customer; validating the customer's e-mail included.
 * @author kyw5lien
 */
public class Customer {
    private String firstName;
    private String lastName;
    private String email;

    /**
     * The constructor of the Customer class.
     * @param firstName the customer's first name.
     * @param lastName  the customer's last name.
     * @param email     the customer's provided e-mail.
     */
    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        if (EmailValidator.isValid(email))
            this.email = email;
    }

    /**
     * A Getter Method to retrieve the Customer's e-mail.
     * @return  the customer's e-mail.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Provides a String object representing the Customer's information.
     * @return a String representing the Customer's information.
     */
    @Override
    public String toString() {
        return Customer.class.getSimpleName() +"{"
                +"firstName:'" + firstName + '\''
                +", lastName:'" + lastName + '\''
                +", email:'" + email + '\''
                +'}';
    }
}
