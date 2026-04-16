package hotel;

public class DeluxeRoom extends Room {
    private boolean hasBalcony;

    public DeluxeRoom(int roomNumber, double pricePerNight, boolean hasBalcony) {
        super(roomNumber, pricePerNight);
        this.hasBalcony = hasBalcony;
    }

    public boolean hasBalcony() { return hasBalcony; }

    @Override
    public String getRoomType() {
        return "Deluxe" + (hasBalcony ? " (with Balcony)" : "");
    }
}