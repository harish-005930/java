package hotel;

public class Reservation {
    private static int idCounter = 1;
    private int reservationId;
    private Customer customer;
    private Room room;
    private int nights;

    public Reservation(Customer customer, Room room, int nights) {
        this.reservationId = idCounter++;
        this.customer = customer;
        this.room = room;
        this.nights = nights;
        room.setAvailable(false); // Mark room as booked upon reservation
    }

    public int getReservationId() { return reservationId; }
    public Customer getCustomer() { return customer; }
    public Room getRoom() { return room; }
    public int getNights() { return nights; }

    public double calculateTotalAmount() {
        return room.getPricePerNight() * nights;
    }

    public void cancel() {
        room.setAvailable(true); // Mark room as available when reservation is cancelled
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId + "\n" +
               customer.toString() + "\n" +
               "Booked " + room.getRoomType() + " Room No: " + room.getRoomNumber() + "\n" +
               "Nights: " + nights + "\n" +
               "Total Amount: $" + calculateTotalAmount();
    }
}

