package uicomponents;

import api.AdminResource;
import api.HotelResource;
import helperclasses.DataHandler;
import model.Customer;
import model.IRoom;
import model.Room;
import model.RoomType;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AdminMenu {
    public static void displayAdminMenuCLI(){
        Scanner scanner = new Scanner(System.in);
        boolean keepRunningAdminMenu = true;
        boolean testDataAdded = false;

        do try {
            System.out.println(
                    "\n" + "-------------------------------------"
                            + "\n" + "Admin Menu"
                            + "\n" + "-------------------------------------"
                            + "\n" + "1. See All Customers"
                            + "\n" + "2. See All Rooms"
                            + "\n" + "3. See All Reservations"
                            + "\n" + "4. Add a Room"
                            + "\n" + "5. Add Test Data"
                            + "\n" + "6. Back to Main Menu"
                            + "\n" + "-------------------------------------"
                            + "\n" + "Please Select a Number for the Menu Option: ");
            int input = Integer.parseInt(scanner.nextLine());
            // int input = scanner.nextInt();
            //scanner.next();

            switch (input) {
                case 1:
                    System.out.println("\n---- See All Customers ----");
                    AdminMenu.displayAllCustomersCLI();
                    break;
                case 2:
                    System.out.println("\n---- See All Rooms ----");
                    AdminMenu.displayAllRoomsCLI();
                    break;
                case 3:
                    System.out.println("\n---- See All Reservations ----");
                    AdminMenu.displayAllReservationsCLI();
                    break;
                case 4:
                    System.out.println("\n---- Add a Room ----");
                    AdminMenu.addRoomCLI();
                    break;
                case 5:
                    System.out.println("\n---- Add Test Data ----");
                    if ((!testDataAdded)) {
                        AdminMenu.addTestDataCLI();
                        testDataAdded = true;
                    } else {
                        System.out.println("Data has already been added!");
                    }
                    break;
                case 6:
                    keepRunningAdminMenu = false;
                    MainMenu.mainMenuCLI();
                    break;
                default:
                    System.out.println("\n" + "Please Select an Option between 1 and 6!" + "\n" + "Press 0 to Exit.");
                    break;
            }
        } catch (Exception e) {
//                    scanner.nextLine();
            System.out.println("Error: Invalid Input!");
            e.getLocalizedMessage();
        } while(keepRunningAdminMenu);
    }

    public static void displayAllCustomersCLI(){
        if(!AdminResource.getAllCustomers().isEmpty()) {
            for (Customer customer : AdminResource.getAllCustomers())
                System.out.println(customer.toString());
        } else{
            System.out.println("No Accounts found!");
        }
    }

    public static void displayAllRoomsCLI(){
        if(!AdminResource.getAllRooms().isEmpty()) {
            for (IRoom room : AdminResource.getAllRooms())
                System.out.println(room.toString());
        } else{
            System.out.println("No Rooms found!");
        }
    }

    public static void displayAllReservationsCLI(){
        if(!AdminResource.displayAllReservations())
            System.out.println("No Reservations found!");
    }

    public static void addRoomCLI(){
        // Buggy Code, Fix  ...
        Set<IRoom> addedRooms = new HashSet<>();
        boolean keepAddingRooms = true;
        Scanner scanner = new Scanner(System.in);

        try{
            do {
                Room room = new Room();

                System.out.println("Room Information - Please Enter ...");
                System.out.println("Room Number: ");
                String roomNumber = scanner.nextLine();
                room.setRoomNumber(roomNumber);

                if((HotelResource.getRoom(roomNumber) != null) || (addedRooms.stream().filter(r -> r.getRoomNumber().equals(roomNumber)).findFirst().isPresent())) {
                    System.out.println("Sorry, Room/Number already exists!");
                    break;
                }

                System.out.println("Room Price: ");
                room.setRoomPrice(Double.parseDouble(scanner.nextLine()));

                System.out.println("Room Type (S)INGLE/(D)OUBLE): ");
                if (scanner.nextLine().equals("s") || scanner.nextLine().equals("S") ) {
                    room.setRoomType(RoomType.SINGLE);
                } else if (scanner.nextLine().equals("d") || scanner.nextLine().equals("D") ) {
                    room.setRoomType(RoomType.DOUBLE);
                }

                System.out.println("Available (Y)es/(N)o: ");
                if (scanner.nextLine().equals("y") || scanner.nextLine().equals("Y") ) {
                    room.setAvailable(true);
                } else if (scanner.nextLine().equals("n") || scanner.nextLine().equals("N")) {
                    room.setAvailable(false);
                }

                addedRooms.add(room);
                System.out.println("addedRooms: " +addedRooms.toString());

                System.out.println("Do you wish to Add another Room? (Y)es/(N)o: ");
                if((scanner.nextLine().equals("n") || scanner.nextLine().equals("N"))) {
                    AdminResource.addRoom(addedRooms);
                    System.out.println("getAllRooms: " +AdminResource.getAllRooms().toString());
                    keepAddingRooms = false;
                    AdminMenu.displayAdminMenuCLI();
                }
            } while(keepAddingRooms);

        } catch(Exception e){
            e.getLocalizedMessage();
        }
    }

    public static void addTestDataCLI(){
        if(DataHandler.addTestData()){
            System.out.println("\n" +"Data Added Successfully!");
        } else {
            System.out.println("\n" +"Failed to Add Data!");
        }
    }
}
