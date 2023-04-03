package testerclasses.model;

import model.Customer;

public class CustomerTester {
    public static void testCustomer(){
        Customer customer = new Customer("Rafael", "Fiorino", "rf@domain.com");
        Customer anotherCustomer = new Customer("Fernanda", "Wyatt", "fw@domain.com");

        System.out.println("\n" +"Test 1: Instantiating 2 Customers ..." +"\n");
        System.out.println(customer.toString());
        System.out.println(anotherCustomer.toString());
    }

    public static void main(String[] args) {
        CustomerTester.testCustomer();
    }
}
