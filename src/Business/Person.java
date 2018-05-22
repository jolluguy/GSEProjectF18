package Business;

import Acquaintance.ICPR;
import Acquaintance.IPerson;

/**
 *
 * @author rasmus
 */
abstract class Person implements IPerson{
        
    private String firstName;
    private String lastName;
    private String roadName;
    private String houseNumber;
    private String floor;
    private int postalCode;
    private String city;
    private String phoneNumber;
    private ICPR cpr;
    
    Person (String cprNumber, String firstName, String lastName, String roadName, String houseNumber, String floor, int postalCode, String city, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.roadName = roadName;
        this.houseNumber = houseNumber;
        this.floor = floor;
        this.postalCode = postalCode;
        this.city = city;
        this.phoneNumber = phoneNumber;
        
        cpr = new CPR(cprNumber);
    }

    @Override
    public String getCprNumber() {
        return this.cpr.getCprNumber();
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getRoadName() {
        return roadName;
    }

    @Override
    public String getHouseNumber() {
        return houseNumber;
    }

    @Override
    public String getFloor() {
        return floor;
    }

    @Override
    public int getPostalCode() {
        return postalCode;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public ICPR getCpr() {
        return cpr;
    }

    void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    void setLastName(String lastName) {
        this.lastName = lastName;
    }

    void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    void setFloor(String floor) {
        this.floor = floor;
    }

    void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    void setCity(String city) {
        this.city = city;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}