package singletons;

import model.Customer;
import model.IRoom;

import java.util.Collection;
import java.util.HashSet;

public class RoomsSingleton {
    // Fields.
    private static RoomsSingleton roomsSingleton;
    private Collection<IRoom> rooms;

    // Private Constructor.
    private RoomsSingleton(){
        this.rooms = new HashSet<>();
    }

    // Static method to create instance of Singleton.
    public static RoomsSingleton getInstance(){
        if(roomsSingleton == null){
            roomsSingleton = new RoomsSingleton();
        }
        return roomsSingleton;
    }

    // Getters.
    public Collection<IRoom> getRooms() {
        return rooms;
    }


    // Setters.
    public void setRooms(Collection<IRoom> rooms) {
        this.rooms = rooms;
    }

    // toString Method.
    @Override
    public String toString() {
        return "RoomsSingleton{" +
                "rooms:" + rooms +
                '}';
    }
}
