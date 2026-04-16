package hotel;

import java.util.*;

public class Hotel {
    private String name;
    private List<Room> rooms;
    private List<Reservation> reservations;

    public Hotel(String name) {
        this.name = name;
        this.rooms = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void displayAvailableRooms() {
        System.out.println("\n--- Available Rooms in " + name + " ---");
        boolean anyAvailable = false;
        for (Room room : rooms) {
            if (room.isAvailable()) {
                System.out.println(room);
                anyAvailable = true;
            }
        }
        if (!anyAvailable) {
            System.out.println("No rooms currently available.");
        }
    }

    public Room findAvailableRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isAvailable()) {
                return room;
            }
        }
        return null;
    }

    public Reservation bookRoom(Customer customer, int roomNumber, int nights) {
        Room room = findAvailableRoom(roomNumber);
        if (room != null) {
            Reservation reservation = new Reservation(customer, room, nights);
            reservations.add(reservation);
            System.out.println("\nBooking successful!");
            return reservation;
        } else {
            System.out.println("\nSorry, Room " + roomNumber + " is not available or does not exist.");
            return null;
        }
    }
    
    public void displayAllReservations() {
        System.out.println("\n--- All Reservations ---");
        if (reservations.isEmpty()) {
            System.out.println("No reservations made yet.");
            return;
        }
        for (Reservation res : reservations) {
            System.out.println(res);
            System.out.println("------------------------");
        }
    }
    
    public void cancelReservation(int reservationId) {
        Reservation toCancel = null;
        for (Reservation res : reservations) {
            if (res.getReservationId() == reservationId) {
                toCancel = res;
                break;
            }
        }
        
        if (toCancel != null) {
            toCancel.cancel();
            reservations.remove(toCancel);
            System.out.println("\nReservation ID " + reservationId + " cancelled successfully.");
        } else {
            System.out.println("\nReservation ID " + reservationId + " not found.");
        }
    }
}

