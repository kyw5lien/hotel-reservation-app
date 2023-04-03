package model;

public interface IRoom {
    // Methods to be implemented.
    public String getRoomNumber();
    public Double getRoomPrice();
    public RoomType getRoomType();
    public boolean isAvailable();
}
