package helperclasses;

import model.*;
import services.CustomerService;
import services.ReservationService;

import java.util.Collection;
import java.util.HashSet;

public class DataHandler {
    public static boolean addTestData(){
        return populateCustomersSet() && populateRoomsSet() && populateReservationsSet() && populateRecommendedRooms();
    }

    // Methods: populate Collections with data ...
    private static boolean populateCustomersSet(){
        // TODO Code here ...
        CustomerService.addCustomer("k@kevin.com", "kevin", "kevin");
        CustomerService.addCustomer("d@danna.com", "danna", "danna");
        CustomerService.addCustomer("a@alannah.com", "alannah", "alannah");
        CustomerService.addCustomer("r@robert.com", "robert", "robert");
        CustomerService.addCustomer("d@david.com", "david", "david");

        return !CustomerService.getAllCustomers().isEmpty();
    }

    private static boolean populateRoomsSet(){
        // TODO Code here ...
        Room r1 = new Room("1",80.00, RoomType.SINGLE, true);
        Room r2 = new Room("2",120.00, RoomType.DOUBLE, true);
        Room r3 = new Room("3",80.00, RoomType.SINGLE, true);
        Room r4 = new Room("4",120.00, RoomType.DOUBLE, true);
        Room r5 = new Room("5",80.00, RoomType.SINGLE, false);

        FreeRoom fr1 = new FreeRoom("6",80.00, RoomType.SINGLE, true);
        FreeRoom fr2 = new FreeRoom("7",120.00, RoomType.DOUBLE, true);
        FreeRoom fr3 = new FreeRoom("8",80.00, RoomType.SINGLE, true);
        FreeRoom fr4 = new FreeRoom("9",120.00, RoomType.DOUBLE, true);
        FreeRoom fr5 = new FreeRoom("10",80.00, RoomType.SINGLE, true);

        Collection<IRoom> rooms = new HashSet<>();
        rooms.add(r1);
        rooms.add(r2);
        rooms.add(r3);
        rooms.add(r4);
        rooms.add(r5);

        rooms.add(fr1);
        rooms.add(fr2);
        rooms.add(fr3);
        rooms.add(fr4);
        rooms.add(fr5);

        ReservationService.getRoomsSingleton().getRooms().addAll(rooms);

        return !ReservationService.getRoomsSingleton().getRooms().isEmpty();
    }

    private static boolean populateReservationsSet() {
        // TODO Code here ...
        int noOfReservations = ReservationService.getRoomsSingleton().getRooms().size() / 3;

        for(int i=0; i<noOfReservations; i++){
            Customer customer = (Customer) RandomCollectionElement.getRandomElement(CustomerService.getAllCustomers());
            IRoom room = (IRoom) RandomCollectionElement.getRandomElement(ReservationService.getRoomsSingleton().getRooms());
            ReservationService.reserveRoom(customer, room, DateWithoutTime.getDateWithoutTime(), DateWithoutTime.getDateWithoutTime());
        }

        return !ReservationService.getReservationsSingleton().getReservations().isEmpty();
    }

    private static boolean populateRecommendedRooms(){
        for(Reservation reservation : ReservationService.getReservationsSingleton().getReservations()){
            ReservationService.addRecommendedRoom(reservation.getRoom());
        }

        return !ReservationService.getRecommendedRoomsSingleton().getRecommendedRooms().isEmpty();
    }
}