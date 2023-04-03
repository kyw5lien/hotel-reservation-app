package testerclasses.other;

import helperclasses.RandomCollectionElement;
import services.CustomerService;

public class RandomCollectionElementTester {
    public static void testRandomCollectionElement() {
        CustomerService.addCustomer("k@kevin.com", "kevin", "kevin");
        CustomerService.addCustomer("d@danna.com", "danna", "danna");
        CustomerService.addCustomer("a@alannah.com", "alannah", "alannah");
        CustomerService.addCustomer("r@robert.com", "robert", "robert");
        CustomerService.addCustomer("d@david.com", "david", "david");

        System.out.println("\n" +"Test 1: RandomCollectionElement: Getting one random Customer of All Customers ..." +"\n");
        System.out.println(RandomCollectionElement.getRandomElement(CustomerService.getAllCustomers()));
    }
}
