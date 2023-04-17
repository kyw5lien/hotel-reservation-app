package model;

import java.lang.reflect.Field;

/**
 * Models information of a Hotel Room; the Hotel Room number, it's price, type, and availability.
 * @author kyw5lien
 * @see RoomType
 */
public class Room implements IRoom {
    private String roomNumber;
    private Double roomPrice;
    private RoomType roomType;
    private boolean isAvailable;

    public Room(){

    }
    /**
     * The constructor of the Hotel's Room class.
     * @param roomNumber the room number.
     * @param roomPrice the room price.
     * @param roomType the room type (e.g: SINGLE / DOUBLES).
     * @param isAvailable the room availability.
     */
    public Room(String roomNumber, Double roomPrice, RoomType roomType, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.roomType = roomType;
        this.isAvailable = isAvailable;
    }

    public String getRoomNumber(){
        return roomNumber;
    }

    public Double getRoomPrice(){
        return roomPrice;
    }

    public RoomType getRoomType(){
        return roomType;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomPrice(Double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        Class<?> c = this.getClass();
        Field[] f = c.getDeclaredFields();
        String s = c.getSimpleName();

        s+="{";
        for(int i = 0; i<f.length; i++){
            f[i].setAccessible(true);
            try {
                s += f[i].getName() +":" +'\'' +f[i].get(this) +'\'';
                if(i<f.length-1) {
                    s+=",";
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        s += "}";

        return s;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Room room = (Room) object;

        return getRoomNumber().equals(room.getRoomNumber());
    }

    @Override
    public int hashCode() {
        return getRoomNumber().hashCode();
    }
}
