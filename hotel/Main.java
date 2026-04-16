package hotel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Grand Java Hotel");

        // Polmorphism: Adding both StandardRoom and DeluxeRoom to a list of Rooms
        hotel.addRoom(new StandardRoom(101, 100.0));
        hotel.addRoom(new StandardRoom(102, 100.0));
        hotel.addRoom(new DeluxeRoom(201, 200.0, true));
        hotel.addRoom(new DeluxeRoom(202, 180.0, false));

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to " + hotel.getClass().getSimpleName() + " Booking System");

        while (!exit) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Show Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Show All Reservations");
            System.out.println("4. Cancel a Reservation");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    hotel.displayAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Customer Contact Number: ");
                    String contact = scanner.nextLine();
                    Customer customer = new Customer(name, contact);

                    hotel.displayAvailableRooms();
                    System.out.print("Enter the Room Number you want to book: ");
                    int roomNum = -1;
                    try {
                         roomNum = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                         System.out.println("Invalid Room Number.");
                         break;
                    }
                    
                    System.out.print("Enter number of nights to stay: ");
                    int nights = -1;
                    try {
                         nights = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                         System.out.println("Invalid number of nights.");
                         break;
                    }

                    if(nights > 0) {
                        Reservation res = hotel.bookRoom(customer, roomNum, nights);
                        if (res != null) {
                            System.out.println("------------------------");
                            System.out.println("Booking Confirmation:");
                            System.out.println(res);
                            System.out.println("------------------------");
                        }
                    } else {
                        System.out.println("Nights must be greater than 0.");
                    }
                    break;
                case 3:
                    hotel.displayAllReservations();
                    break;
                case 4:
                    System.out.print("Enter Reservation ID to cancel: ");
                    int cancelId = -1;
                    try {
                        cancelId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid Reservation ID.");
                        break;
                    }
                    hotel.cancelReservation(cancelId);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Thank you for using the Hotel Reservation System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}

