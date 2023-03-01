package EntityManager;

import java.util.Objects;

public class Address {
    private int id;
    private int customer_id;
    private String code;
    private String country;
    private String region;
    private String city;
    private String street;
    private int house;
    private String frame;
    private int apartment;

    public Address() {
    }

    public Address(int customer_id, String code) {
        this.customer_id = customer_id;
        this.code = code;
    }

    public Address(int customer_id, String code, String country, String region, String city,
                   String street, int house, String frame, int apartment) {
        this.customer_id = customer_id;
        this.code = code;
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.house = house;
        this.frame = frame;
        this.apartment = apartment;
    }

    public Address(int id, int customer_id, String code, String country, String region,
                   String city, String street, int house, String frame, int apartment) {
        this.id = id;
        this.customer_id = customer_id;
        this.code = code;
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.house = house;
        this.frame = frame;
        this.apartment = apartment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Address address = (Address) object;
        return house == address.house && apartment == address.apartment && Objects.equals(id, address.id)
                && Objects.equals(customer_id, address.customer_id) && Objects.equals(code, address.code)
                && Objects.equals(country, address.country) && Objects.equals(region, address.region)
                && Objects.equals(city, address.city) && Objects.equals(street, address.street)
                && Objects.equals(frame, address.frame);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customer_id, code, country, region, city, street, house, frame, apartment);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", code='" + code + '\'' +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", frame='" + frame + '\'' +
                ", apartment=" + apartment +
                '}';
    }
}
