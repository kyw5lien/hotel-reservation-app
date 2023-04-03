package testerclasses.model;

import model.Room;
import model.RoomType;

public class RoomTester {
    public static void testRoom(){
        Room singlesRoom = new Room("100", 80.00, RoomType.SINGLE, true);
        Room doublesRoom = new Room("200", 120.00, RoomType.DOUBLE, false);

        System.out.println("\n" +"Test 1: Instantiating 2 Rooms ..." +"\n");
        System.out.println(singlesRoom.toString());
        System.out.println(doublesRoom.toString());

    }
}
