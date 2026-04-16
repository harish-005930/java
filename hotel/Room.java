package hotel;

public abstract class Room {
    private int roomNumber;
    private double pricePerNight;
    private boolean isAvailable;

    public Room(int roomNumber, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.pricePerNight = pricePerNight;
        this.isAvailable = true;
    }

    public int getRoomNumber() { return roomNumber; }
    public double getPricePerNight() { return pricePerNight; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean available) { isAvailable = available; }

    // Abstract method to demonstrate abstraction and polymorphism
    public abstract String getRoomType();

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + ", Type: " + getRoomType() + 
               ", Price: $" + pricePerNight + ", Available: " + (isAvailable ? "Yes" : "No");
    }
}

