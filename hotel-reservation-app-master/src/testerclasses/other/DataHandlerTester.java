package testerclasses.other;

import helperclasses.DataHandler;
import services.CustomerService;
import services.ReservationService;

public class DataHandlerTester {
    public static void testDataHandler() {
        DataHandler.addTestData();

        System.out.println("\n" +"Test 1: Data Handler: Get All Customers populated ..." +"\n");
        System.out.println(CustomerService.getAllCustomers().toString());
        System.out.println("\n" +"Test 1: Data Handler: Get All Rooms populated ..." +"\n");
        System.out.println(ReservationService.getRoomsSingleton().getRooms().toString());
        System.out.println("\n" +"Test 1: Data Handler: Print All Reservations populated ..." +"\n");
        ReservationService.printAllReservations();
    }
}
