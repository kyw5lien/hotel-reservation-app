package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import services.CustomerService;
import services.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    // Methods.
    // Customer ...
    public static void addCustomer(String email, String firstName, String lastName){
        CustomerService.addCustomer(email, firstName, lastName);
    }
    public static Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }

    // Room ...
    public static IRoom getRoom(String roomNumber){
        return ReservationService.getRoom(roomNumber);
    }
    public static Collection<IRoom> findRoom(Date checkIn, Date checkOut){
        return ReservationService.findRooms(checkIn, checkOut);
    }

    // Reservation ...
    public static Reservation bookRoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
        return ReservationService.reserveRoom(CustomerService.getCustomer(customerEmail), room, checkInDate, checkOutDate);
    }

    public static Collection<Reservation> getCustomersReservations(String customerEmail){
        return ReservationService.getCustomersReservations(CustomerService.getCustomer(customerEmail));
    }

    // Recommended Rooms ...
    public static IRoom addRecommendedRoom(IRoom recommendedRoom){
        // ...
        return ReservationService.addRecommendedRoom(recommendedRoom);
    }

    public static Collection<IRoom> findRecommendedRooms(Date checkIn, Date checkOut){
        return ReservationService.findRecommendedRooms(checkIn, checkOut);
    }

    public static Collection<IRoom> getRecommendedRooms(){
        return ReservationService.getRecommendedRoomsSingleton().getRecommendedRooms().keySet();
    }
}
