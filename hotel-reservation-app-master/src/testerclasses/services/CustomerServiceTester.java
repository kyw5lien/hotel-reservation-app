package testerclasses.services;

import services.CustomerService;

public class CustomerServiceTester {
    public static void testCustomerService() {
        CustomerService.addCustomer("k@kevin.com", "kevin", "kevin");
        CustomerService.addCustomer("d@danna.com", "danna", "danna");
        CustomerService.addCustomer("a@alannah.com", "alannah", "alannah");

        System.out.println("\n" +"Test 1: Get Added Customers ...");
        System.out.println(CustomerService.getAllCustomers().toString());
        System.out.println(CustomerService.getCustomer("k@kevin.com").toString());
        System.out.println(CustomerService.getCustomer("d@danna.com").toString());
        System.out.println(CustomerService.getCustomer("a@alannah.com").toString());
    }
}
