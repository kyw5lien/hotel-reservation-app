package uicomponents;

import api.HotelResource;
import helperclasses.EmailValidator;
import model.IRoom;
import model.Reservation;
import singletons.RecommendedRoomsSingleton;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;

public class MainMenu {
    public static void mainMenuCLI() {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunningMainMenu = true;

        do try {
            System.out.println(
                    "\n" + "-------------------------------------"
                            + "\n" + "Main Menu"
                            + "\n" + "-------------------------------------"
                            + "\n" + "1. Find and Reserve a Room"
                            + "\n" + "2. See my Reservations"
                            + "\n" + "3. Create an Account"
                            + "\n" + "4. Admin"
                            + "\n" + "0. Exit"
                            + "\n" + "-------------------------------------"
                            + "\n" + "Please Select a Number for the Menu Option: "
            );
            //int input = Integer.parseInt(scanner.next());
            //int input = scanner.nextInt();
            int input = Integer.parseInt(scanner.nextLine());

            switch (input) {
                case 1:
                    System.out.println("\n----- Find and Reserve a Room -----");
                    MainMenu.findAndReserveRoomCLI();
                    break;
                case 2:
                    System.out.println("\n------- See my Reservations -------");
                    MainMenu.seeMyReservationsCLI();
                    break;
                case 3:
                    System.out.println("\n-------- Create an Account --------");
                    MainMenu.createAccountCLI();
                    break;
                case 4:
                    AdminMenu.displayAdminMenuCLI();
                    break;
                case 0:
                    keepRunningMainMenu = false;
                    System.out.println("\n" + "Exiting now ...");
                    //System.exit(0); // Forces system to exit.
                    break;
                default:
                    System.out.println("\n" + "Please Select an Option between 1 and 4! Press 0 to Exit." + "\n");
                    break;
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid Input!");
            e.getLocalizedMessage();
        } while (keepRunningMainMenu);
    }


    public static void findAndReserveRoomCLI() {
        Scanner scanner = new Scanner(System.in);

        try {
            // 1. Read checkInDate and checkOutDate ...
            System.out.println("Enter CheckIn Date - MM/dd/yyyy (e.g: 02/01/2022)");
            Date checkInDate = new SimpleDateFormat("MM/dd/yyyy").parse(scanner.nextLine());
            System.out.println("Enter CheckOut Date - MM/dd/yyyy (e.g: 02/21/2022)");
            Date checkOutDate = new SimpleDateFormat("MM/dd/yyyy").parse(scanner.nextLine());

            // Get rooms available ...
            Collection<IRoom> roomsAvailable = HotelResource.findRoom(checkInDate, checkOutDate);
            Collection<IRoom> recommendedRoomsAvailable;

            Date alternativeCheckInDate = null;
            Date alternativeCheckOutDate = null;
            boolean alternativeDates = false;

            // 2. Find Available Rooms ...
            if (roomsAvailable.isEmpty()) {
                // Suggest alternative dates ...
                System.out.println("All Rooms are booked for the Date! Looking for alternative dates/rooms ...");

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(checkInDate);
                calendar.add(Calendar.DAY_OF_MONTH, 7);
                alternativeCheckInDate = calendar.getTime();

                calendar.setTime(checkOutDate);
                calendar.add(Calendar.DAY_OF_MONTH, 7);
                alternativeCheckOutDate = calendar.getTime();

                recommendedRoomsAvailable = HotelResource.findRecommendedRooms(alternativeCheckInDate, alternativeCheckOutDate);
                alternativeDates = true;

            } else {
                // Display Available Rooms ...
                System.out.println("Available Rooms: ");
                for (IRoom room : roomsAvailable) {
                    System.out.println(room.toString());
                }

                recommendedRoomsAvailable = HotelResource.findRecommendedRooms(checkInDate, checkOutDate);
            }

            // 3. Display Recommended Rooms here ...
            System.out.println("Recommended Rooms:");
            if (!recommendedRoomsAvailable.isEmpty()) {
                for (IRoom room : recommendedRoomsAvailable)
                    System.out.println(room.toString());
            } else {
                System.out.println("There are no recommended rooms at the moment.");
            }

            // 4. Proceed to Room Reservation ...
            System.out.println("Would you like to Book a Room? (Y/N): ");
            if (scanner.nextLine().equalsIgnoreCase("Y")) {
                System.out.println("Do you have an Account with us? (Y/N): ");
                if (scanner.nextLine().equalsIgnoreCase("Y")) {
                    String email = readValidEmail();

                    IRoom roomToBeReserved;
                    do {
                        System.out.println("What Room/Number would you like to Reserve?");
                        String roomNumber = String.valueOf(scanner.nextInt());

                        roomToBeReserved = HotelResource.getRoom(roomNumber);

                        if(roomsAvailable.contains(roomToBeReserved) || recommendedRoomsAvailable.contains(roomToBeReserved)){
                            break;
                        }
                        System.out.println("Room/Number is not available! Pick a number from the List of Available/Recommended Rooms.");

                    }while(true);

                    if(!alternativeDates) {
                        System.out.println("\n" + "Reservation Completed Successfully!" + "\n"
                                + HotelResource.bookRoom(email, roomToBeReserved, checkInDate, checkOutDate).toString());
                    }else { // Reserve room with alternative dates ...
                        System.out.println("\n" + "Reservation Completed Successfully!" + "\n"
                                + HotelResource.bookRoom(email, roomToBeReserved, alternativeCheckInDate, alternativeCheckOutDate).toString());
                    }

                    // Update recommendedRoomsSingleton ...
                    // Print Recommended Rooms: checking purpose ...
                    HotelResource.addRecommendedRoom(roomToBeReserved);
                    System.out.println("Updated Recommended Rooms: "+ RecommendedRoomsSingleton.getInstance().toString());
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void seeMyReservationsCLI() {
        String email = MainMenu.readValidEmail();
        if(HotelResource.getCustomersReservations(email) == null){
            System.out.println("There are no Reservations for the account: " +email +" !");
        } else{
            for(Reservation reservation: HotelResource.getCustomersReservations(email))
                System.out.println(reservation.toString());
        }
    }

    public static void createAccountCLI() {
        String email, firstName, lastName;
        Scanner scanner = new Scanner(System.in);

        do {
            email = MainMenu.readValidEmail();

            if(HotelResource.getCustomer(email) == null) {
                System.out.println("Enter First Name:");
                firstName = scanner.nextLine();

                System.out.println("Enter Last Name:");
                lastName = scanner.nextLine();

                HotelResource.addCustomer(email, firstName, lastName);
            } else {
                System.out.println("An Account with the provided e-mail already exists!");
            }
        } while (HotelResource.getCustomer(email) == null);
    }

    public static String readValidEmail(){
        String email = null;
        Scanner scanner = new Scanner(System.in);
        try{
            do {
                System.out.println("Enter E-mail (e.g: name@domain.com)");
                email = scanner.nextLine();

                if(!EmailValidator.isValid(email)){
                    System.out.println("Error: Invalid E-mail!");
                }
            } while (!EmailValidator.isValid(email));
        } catch(Exception e){
            e.printStackTrace();
        }
        return email;
    }
}