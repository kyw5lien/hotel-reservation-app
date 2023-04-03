package api;

import model.Customer;
import model.IRoom;
import services.CustomerService;
import services.ReservationService;

import java.util.Collection;
import java.util.Set;

public class AdminResource {
    // Methods.
    // Customer ...
    public static Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }
    public static Collection<Customer> getAllCustomers(){
        return CustomerService.getAllCustomers();
    }
    // Room ...
    public static void addRoom(Set<IRoom> rooms){
        for(IRoom room: rooms){
            ReservationService.addRoom(room);
        }
    }
    public static Collection<IRoom> getAllRooms(){
        return ReservationService.getRoomsSingleton().getRooms();
    }

    // Reservation ...
    public static boolean displayAllReservations(){
        return ReservationService.printAllReservations();
    }

    // Recommended Rooms ...
    public static boolean displayAllRecommendedRooms(){
        return ReservationService.printAllRecommendedRooms();
    }
}
