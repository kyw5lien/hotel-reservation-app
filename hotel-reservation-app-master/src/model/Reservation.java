package model;

import model.IRoom;

import java.util.Date;

public class Reservation {
    // Fields.
    private Customer customer;
    private IRoom room;
    private Date checkInDate;
    private Date checkOutDate;

    // Constructor.
    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    // Getters.
    public Customer getCustomer() {
        return customer;
    }

    public IRoom getRoom() {
        return room;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    // Setters.
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setRoom(IRoom room) {
        this.room = room;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    // toString method.
    @Override
    public String toString() {
        return "Reservation{" +
                "customer:" + customer +
                ", room:" + room +
                ", checkInDate:" + checkInDate +
                ", checkOutDate:" + checkOutDate +
                '}';
    }

    /*
    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                "\n" +
                "--------------------------------------" +
                "\n" +
                "\t" + customer + "\n" +
                "\t" + room +
                "\t" + "CheckIn Date: " + checkInDate + "\n" +
                "\t" + "CheckOut Date: " +checkOutDate + "\n";
    }
    */
}
