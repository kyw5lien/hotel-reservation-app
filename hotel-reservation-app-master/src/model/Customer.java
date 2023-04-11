package model;

import helperclasses.EmailValidator;
import java.lang.reflect.Field;

/**
 * Customer class: models information of a Customer; validating the customer's e-mail included.
 * @author kyw5lien
 */
public class Customer {
    private final String firstName;
    private final String lastName;
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
        Class<?> c = this.getClass();
        Field[] f = c.getDeclaredFields();
        String s = c.getSimpleName();

        s+="{";
        for(int i = 0; i<f.length; i++){
            f[i].setAccessible(true);
            try {
                s += f[i].getName() +":" +'\'' +f[i].get(this) +'\'';
                if(i<f.length-1) {
                    s+=",";
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        s+="}";
        
        return s;
    }
}
