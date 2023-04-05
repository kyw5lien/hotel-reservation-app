package model;
import java.lang.reflect.Field;
import helperclasses.EmailValidator;

/**
 * Customer class: models information of a Customer; validating the customer's e-mail included.
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
     * @return the customer's e-mail.
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
        int i = 0;
        Field[] declaredFields = Customer. class.getDeclaredFields();
        return Customer.class.getSimpleName() +"{"
                +declaredFields[i].getName()  +":" +'\'' +Customer.this.firstName +'\'' +","
                +declaredFields[++i].getName() +":" +'\''  +Customer.this.lastName +'\'' +","
                +declaredFields[++i].getName() +":" +'\'' +Customer.this.email  +'\''
        +'}';
    }
}
