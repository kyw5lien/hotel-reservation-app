package testerclasses;

import testerclasses.model.CustomerTester;
import testerclasses.model.FreeRoomTester;
import testerclasses.model.ReservationTester;
import testerclasses.model.RoomTester;
import testerclasses.other.DataHandlerTester;
import testerclasses.other.EmailValidatorTester;
import testerclasses.other.RandomCollectionElementTester;
import testerclasses.services.CustomerServiceTester;
import testerclasses.services.ReservationServiceTester;

public class RunTests {
    public static void main(String[] args) {
        // Run Tests ...
        // model ...
        CustomerTester.testCustomer();
        RoomTester.testRoom();
        FreeRoomTester.testFreeRoom();
        ReservationTester.testReservation();
        // services ...
        CustomerServiceTester.testCustomerService();
        ReservationServiceTester.testReservationService();  // ReservationService.isReservationDateWithinRange needs fixing ...
        // helperclasses ...
        DataHandlerTester.testDataHandler();
        EmailValidatorTester.testEmailValidator();
        RandomCollectionElementTester.testRandomCollectionElement();
        // All Tests working as expected!
    }
}
