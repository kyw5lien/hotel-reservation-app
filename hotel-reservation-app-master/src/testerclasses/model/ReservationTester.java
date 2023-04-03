package testerclasses.model;

import model.Customer;
import model.FreeRoom;
import model.Reservation;
import model.RoomType;

import java.util.Date;

public class ReservationTester {
    public static void testReservation(){
        Customer customer = new Customer("Jason","Norton", "j@norton.com");
        FreeRoom freeRoom = new FreeRoom("500", 160.00, RoomType.DOUBLE, false);
        Date checkInDate = new Date(2022, 02, 22);
        Date checkOutDate = new Date(2022,02,23);
        Reservation reservation = new Reservation(customer, freeRoom, checkInDate, checkOutDate);

        System.out.println("\n" +"Test 1: Instantiating 1 Reservation ..." +"\n");
        System.out.println(reservation.toString());
    }
}
