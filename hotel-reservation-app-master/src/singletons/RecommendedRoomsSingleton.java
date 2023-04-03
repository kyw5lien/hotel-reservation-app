package singletons;

import model.IRoom;

import java.util.HashMap;
import java.util.Map;

public class RecommendedRoomsSingleton {
    // Fields.
    private static RecommendedRoomsSingleton recommendedRoomsSingleton;
    private Map<IRoom, Integer> recommendedRooms;

    // Private Constructor.
    private RecommendedRoomsSingleton(){
        this.recommendedRooms = new HashMap<>();
    }

    // Static method to create instance of Singleton.
    public static RecommendedRoomsSingleton getInstance(){
        if(recommendedRoomsSingleton == null){
            recommendedRoomsSingleton = new RecommendedRoomsSingleton();
        }
        return recommendedRoomsSingleton;
    }

    // Getters.
    public Map<IRoom, Integer> getRecommendedRooms() {
        return recommendedRooms;
    }

    // Setters.
    public void setRecommendedRooms(Map<IRoom, Integer> recommendedRooms) {
        this.recommendedRooms = recommendedRooms;
    }

    // toString Method.
    @Override
    public String toString() {
        return "RecommendedRoomsSingleton{" +
                "recommendedRooms:" + recommendedRooms +
                '}';
    }
}
