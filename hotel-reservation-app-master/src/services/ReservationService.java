package services;

import model.Customer;
import model.IRoom;
import model.Reservation;
import singletons.RecommendedRoomsSingleton;
import singletons.ReservationsSingleton;
import singletons.RoomsSingleton;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

public class ReservationService {
    // Fields.
    private static final ReservationsSingleton reservations = ReservationsSingleton.getInstance();
    private static final RoomsSingleton rooms = RoomsSingleton.getInstance();
    private static final RecommendedRoomsSingleton recommendedRooms = RecommendedRoomsSingleton.getInstance();

    // Methods.
    // Room ...
    public static void addRoom(IRoom room){
        rooms.getRooms().add(room);
    }

    public static IRoom getRoom(String roomId){
        for(IRoom room: rooms.getRooms()){
            if(roomId.equals(room.getRoomNumber())){
                return room;
            }
        }
        return null;
    }

    public static Reservation reserveRoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Collection<IRoom> roomsAvailable = ReservationService.findRooms(checkInDate, checkOutDate);

        if(roomsAvailable.isEmpty()){
            return null;
        } else {
            Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
            reservations.getReservations().add(reservation);
            return reservation;
        }
    }

    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate){
        Collection<IRoom> copyOfRooms = new HashSet<>(ReservationService.getRoomsSingleton().getRooms());

        for(Reservation reservation : ReservationService.getReservationsSingleton().getReservations())
            if(ReservationService.isReservationDatesWithinRange(reservation, checkInDate, checkOutDate))
                copyOfRooms.remove(reservation.getRoom());

        return copyOfRooms;
    }

    public static Collection<IRoom> findRecommendedRooms(Date checkInDate, Date checkOutDate){
        Collection<IRoom> copyOfRecommendedRooms = new HashSet<>(ReservationService.getRecommendedRoomsSingleton().getRecommendedRooms().keySet());

        for(Reservation reservation : ReservationService.getReservationsSingleton().getReservations())
            if(ReservationService.isReservationDatesWithinRange(reservation, checkInDate, checkOutDate))
                copyOfRecommendedRooms.remove(reservation.getRoom());
        return copyOfRecommendedRooms;
    }

    // Recommended Rooms ...
    public static IRoom addRecommendedRoom(IRoom room){
        // TODO CODE here ...
        if(recommendedRooms.getRecommendedRooms().get(room) == null){
            recommendedRooms.getRecommendedRooms().put(room, 1);
        } else {
            // TODO CODE here ...
        }
        return room;
    }

    public static IRoom getRecommendedRoom(String roomId){
        // TODO CODE here ...
        return null;
    }

    public static IRoom updateRecommendedRoom(String roomId) {
        // TODO CODE here...
        return null;
    }

    public static boolean printAllRecommendedRooms(){
        if(!recommendedRooms.getRecommendedRooms().isEmpty()){
            for(IRoom room : recommendedRooms.getRecommendedRooms().keySet()){
                System.out.println(room.toString());
            }
            return true;
        } else{
            return false;
        }
    }

    // Reservations ...
    public static Collection<Reservation> getCustomersReservations(Customer customer){
        Collection<Reservation> customersReservations = new HashSet<>();
        for(Reservation reservation : reservations.getReservations()){
            if(Objects.equals(customer.getEmail(), reservation.getCustomer().getEmail())){
                    customersReservations.add(reservation);
            }
        }
        return customersReservations.isEmpty() ? null: customersReservations;
    }

    public static boolean printAllReservations(){
        if(!reservations.getReservations().isEmpty()) {
            for (Reservation reservation : reservations.getReservations())
                System.out.println(reservation.toString());
            return true;
        } else{
            return false;
        }
    }

    // Helper Methods ...
    static boolean isReservationDatesWithinRange(Reservation reservation, Date checkInDate, Date checkOutDate){
        if((checkInDate.compareTo(reservation.getCheckInDate()) == 0) && (checkOutDate.compareTo(reservation.getCheckOutDate()) == 0))
            return true;

        if((checkInDate.before(reservation.getCheckInDate())) && (checkOutDate.after(reservation.getCheckInDate()))
                && (checkOutDate.before(reservation.getCheckOutDate())))
            return true;

        if(checkInDate.after(reservation.getCheckInDate()) && (checkInDate.before(reservation.getCheckOutDate()))
                && (checkOutDate.after(reservation.getCheckOutDate())))
            return true;
        if((checkInDate.before(reservation.getCheckInDate())) && (checkOutDate.after(reservation.getCheckOutDate())))
            return true;

        return (checkInDate.after(reservation.getCheckInDate())) && (checkOutDate.before(reservation.getCheckOutDate()));
    }

    // Getters.
    public static RoomsSingleton getRoomsSingleton() {
        return rooms;
    }

    public static ReservationsSingleton getReservationsSingleton() {
        return reservations;
    }

    public static RecommendedRoomsSingleton getRecommendedRoomsSingleton() {
        return recommendedRooms;
    }
}
