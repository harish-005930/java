package hotel;

public class Customer {
    private String name;
    private String contactNumber;

    public Customer(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getName() { return name; }
    public String getContactNumber() { return contactNumber; }

    @Override
    public String toString() {
        return "Customer Name: " + name + ", Contact: " + contactNumber;
    }
}
