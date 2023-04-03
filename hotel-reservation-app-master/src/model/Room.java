package model;

/**
 *  Hotel's Room class: models information about the hotel's room
 *  properties such as room number, it's price, type and availability.
 *
 * @author
 */
public class Room implements IRoom {
    // Fields.
    private String roomNumber;
    private Double roomPrice;
    private RoomType roomType;
    private boolean isAvailable;

    // Constructors.
    public Room() {
        // Emty constructor ...
    }

    /**
     * The constructor of the Hotel's Room class.
     * @param roomNumber the room number.
     * @param roomPrice the room price.
     * @param roomType the type of the room (e.g: single's / doubles).
     * @param isAvailable the room's availability.
     */
    public Room(String roomNumber, Double roomPrice, RoomType roomType, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.roomType = roomType;
        this.isAvailable = isAvailable;
    }

    // Getters.
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

    // Setters.
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

    // toString Method.
    @Override
    public String toString() {
        return "Room{" +
                "roomNumber:'" + roomNumber + '\'' +
                ", roomPrice:" + roomPrice +
                ", roomType:" + roomType +
                ", isAvailable:" + isAvailable +
                '}';
    }

    /**
     * Provides information about the Hotel's Room.
     * @return a String representing the Hotel's Room information.
     */
    /*
    @Override
    public String toString() {
        String roomDescription = this.getClass().getSimpleName() +
                "\n" +
                "\t" +"--------------------------------------" +
                "\n" +
                "\t" + "Number: " + roomNumber + "\n" +
                "\t" + "Price: " + roomPrice + "\n" +
                "\t" + "Type: " + roomType + "\n" +
                "\t" + "Available: ";

        if(isAvailable) {
            roomDescription +=  "Yes" + "\n";
        } else {
            roomDescription += "No" + "\n";
        }

        return roomDescription;
    }
    */

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