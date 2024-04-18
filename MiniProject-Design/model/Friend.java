package model;
/**
 *
 * @author (Matias, Jeppe, Oscar, Magnus, Kasper)
 * @version (16/04/2024)
 */
public class Friend {
    private String name;
    private String address;
    private int postalCode;
    private String city;
    private int phone;

    public Friend(String name, String address, int postalCode, String city, int phone) {
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public int getPhone() {
        return phone;
    }

    public void printFriendInfo() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Postal Code: " + postalCode);
        System.out.println("City: " + city);
        System.out.println("Phone: " + phone);
        System.out.println("");
    }
}
