package services;

import model.Customer;
import singletons.CustomersSingleton;

import java.util.Collection;

public class CustomerService {
    // Fields.
    private static final CustomersSingleton customers = CustomersSingleton.getInstance();

    // Methods.
    public static void addCustomer(String email, String firstName, String lastName){
        Customer customer = new Customer(firstName, lastName, email);
        CustomerService.getAllCustomers().add(customer);
    }

    public static Customer getCustomer(String customerEmail){
        for(Customer customer: CustomerService.getAllCustomers()){
            if(customerEmail.equals(customer.getEmail())) {
                return customer;
            }
        }
        return null;
    }

    public static Collection<Customer> getAllCustomers(){
        // TODO CODE here ...
        return customers.getCustomers();
    }
}
