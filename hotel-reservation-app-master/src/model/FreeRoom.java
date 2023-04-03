package model;

/**
 * Hotel's Free Room class: models information about the hotel's free room
 *  properties such as room number, it's price, type and availability.
 *
 * @author
 */
public class FreeRoom extends Room{
    /**
     * The constructor of the Hotel's Room class.
     * @param roomNumber the room number.
     * @param roomPrice the room price.
     * @param roomType the type of the room (e.g: single's / double's).
     * @param isAvailable the room's availability.
     */
    public FreeRoom(String roomNumber, Double roomPrice, RoomType roomType, boolean isAvailable){
        super(roomNumber, 0.00, roomType, isAvailable);
    }

    /**
     * Provides information about the Hotel's Free Room.
     * @return a String representing the Hotel's Free Room information.
     */
    @Override
    public String toString() {
        return super.toString().replace("FreeRoom", "Free Room");
    }
}
