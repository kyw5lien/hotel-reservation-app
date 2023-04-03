package testerclasses.model;

import model.FreeRoom;
import model.RoomType;

public class FreeRoomTester {
    public static void testFreeRoom(){
        FreeRoom freeSinglesRoom = new FreeRoom("300", 90.00, RoomType.SINGLE, true);
        FreeRoom freeDoublesRoom = new FreeRoom("400", 130.00, RoomType.DOUBLE, false);

        System.out.println("\n" +"Test 1: Instantiating 2 Free Rooms ..." +"\n");
        System.out.println(freeSinglesRoom.toString());
        System.out.println(freeDoublesRoom.toString());
    }

    public static void main(String[] args) {
        FreeRoomTester.testFreeRoom();
    }
}
