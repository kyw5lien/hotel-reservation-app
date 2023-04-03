package singletons;

import model.Reservation;

import java.util.Collection;
import java.util.HashSet;

public class ReservationsSingleton {
    // Fields.
    private static ReservationsSingleton reservationsSingleton;
    private Collection<Reservation> reservations;

    // Private Constructor.
    private ReservationsSingleton(){
        this.reservations = new HashSet<>();
    }

    // Static method to create instance of Singleton.
    public static ReservationsSingleton getInstance(){
        if(reservationsSingleton == null){
            reservationsSingleton = new ReservationsSingleton();
        }
        return reservationsSingleton;
    }

    // Getters.
    public Collection<Reservation> getReservations() {
        return reservations;
    }

    // Setters.
    public void setReservations(Collection<Reservation> reservations) {
        this.reservations = reservations;
    }

    // toString Method.
    @Override
    public String toString() {
        return "ReservationsSingleton{" +
                "reservations=" + reservations +
                '}';
    }
}
