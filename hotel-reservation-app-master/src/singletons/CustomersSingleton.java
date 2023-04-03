package singletons;


import model.Customer;

import java.util.Collection;
import java.util.HashSet;

public class CustomersSingleton {
    // Fields.
    private static CustomersSingleton roomsSingleton;
    private Collection<Customer> customers;

    // Private Constructor.
    private CustomersSingleton(){
        this.customers = new HashSet<>();
    }

    // Static method to create instance of Singleton.
    public static CustomersSingleton getInstance(){
        if(roomsSingleton == null){
            roomsSingleton = new CustomersSingleton();
        }
        return roomsSingleton;
    }

    // Getters.
    public Collection<Customer> getCustomers() {
        return customers;
    }

    // Setters.
    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }

    // toString Method...
    @Override
    public String toString() {
        return "CustomersSingleton{" +
                "customers=" + customers +
                '}';
    }
}
