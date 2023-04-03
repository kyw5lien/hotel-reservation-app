package testerclasses.services;

import model.*;
import services.ReservationService;

import java.util.Date;

public class ReservationServiceTester {
    public static void testReservationService() {
        Customer customer = new Customer("kevin", "kevin", "k@kevin.com");
        Customer lateCustomer = new Customer("dara", "dara", "d@dara.com");
        Room room = new Room("1",80.00, RoomType.SINGLE, true);
        FreeRoom anotherRoom = new FreeRoom("2",120.00, RoomType.DOUBLE, true);
        Reservation reservation = new Reservation(customer, room, new Date(2022, 01, 01), new Date(2022, 1, 10));
        Reservation lateReservation = new Reservation(lateCustomer, anotherRoom, new Date(2022, 02, 01 ), new Date(2022, 02, 10));

        // Test 1: Add Room ...
        System.out.println("\n" +"Test 1: Add Room and retrieve Rooms added by Room Number ..." +"\n");
        ReservationService.addRoom(room);
        ReservationService.addRoom(anotherRoom);
        System.out.println(ReservationService.getRoom(room.getRoomNumber()));
        System.out.println(ReservationService.getRoom(anotherRoom.getRoomNumber()));

        // Test 2: Get Rooms added ...
        System.out.println("\n" + "Test 2: Get Rooms added ..."+"\n");
        System.out.println(ReservationService.getRoom("1").toString());
        System.out.println(ReservationService.getRoom("2").toString());

        // Test 3: Reserve a Room ...
        System.out.println("\n" +"Test 3: Reserve a Room ..." +"\n");
        System.out.println(ReservationService.reserveRoom(reservation.getCustomer(), reservation.getRoom(), reservation.getCheckInDate(), reservation.getCheckOutDate()));
        System.out.println(ReservationService.reserveRoom(lateReservation.getCustomer(), lateReservation.getRoom(), lateReservation.getCheckInDate(), lateReservation.getCheckOutDate()));

        // Test 4: Find Available Rooms based on date ...
        System.out.println("\n" +"Test 4a: Finds All The Rooms within the period ..." +"\n");
        System.out.println(ReservationService.findRooms(new Date(2022, 03, 6), new Date(2022, 05, 10)));
        System.out.println(ReservationService.findRooms(new Date(2022, 03, 12), new Date(2022, 05, 13)));
        System.out.println("\n" +"Test 4.b: Finds Rooms 2 and 1 for each period respectively; Retrieves Available Room No 2, Room No 1 is taken ..." +"\n");
        System.out.println(ReservationService.findRooms(reservation.getCheckInDate(), reservation.getCheckOutDate()));
        System.out.println(ReservationService.findRooms(lateReservation.getCheckInDate(), lateReservation.getCheckOutDate()));
        System.out.println("-> " +ReservationService.findRooms(new Date(2022, 01, 01), new Date(2022, 01, 10)));
        System.out.println("\n" +"Test 4.c: All Rooms are available in the following periods..." +"\n");
        System.out.println(ReservationService.findRooms(new Date(2022, 03, 13), new Date(2022, 05, 15)));
        System.out.println(ReservationService.findRooms(new Date(2022, 03, 14), new Date(2022, 05, 15)));

        // Test 5: Get Specific Customer reservations ...
        System.out.println("\n" +"Test 5: Get Specific Customer reservations ..." +"\n");
        System.out.println(ReservationService.getCustomersReservations(customer).toString());
        System.out.println(ReservationService.getCustomersReservations(lateCustomer).toString());

        // Test 6: Print All Reservations ...
        System.out.println("\n" +"Test 6: Print All Reservations ..." +"\n");
        ReservationService.printAllReservations();

        // Test 7: Print All Recomended Rooms ...
        System.out.println("\n" +"Test 7: Print All Recommended Rooms ..." +"\n");
        System.out.println(ReservationService.printAllRecommendedRooms());
    }
}
