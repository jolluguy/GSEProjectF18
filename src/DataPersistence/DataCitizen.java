/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPersistence;

import Acquaintance.ICPR;
import Acquaintance.ICitizen;

/**
 *
 * @author Rasmus
 */
class DataCitizen implements ICitizen {

    private String firstName;
    private String lastName;
    private String roadName;
    private String houseNumber;
    private String floor;
    private int postalCode;
    private String city;
    private String phoneNumber;
    private ICPR cpr;

    public DataCitizen(long cprNumber, String firstname, String surname, String roadName, String houseNumber, String floor, int postNumber, String city, String tlfNumber) {
        this.firstName = firstname;
        this.lastName = surname;
        this.roadName = roadName;
        this.houseNumber = houseNumber;
        this.floor = floor;
        this.postalCode = postNumber;
        this.city = city;
        this.phoneNumber = tlfNumber;
        
        this.cpr = new DataCPR(cprNumber);
    }

    
@Override
    public String getFirstName() {
        return firstName;
    }
    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Override
    public String getLastName() {
        return lastName;
    }
    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    @Override
    public String getRoadName() {
        return roadName;
    }
    @Override
    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }
    @Override
    public String getHouseNumber() {
        return houseNumber;
    }
    @Override
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
    @Override
    public String getFloor() {
        return floor;
    }
    @Override
    public void setFloor(String floor) {
        this.floor = floor;
    }
    @Override
    public int getPostalCode() {
        return postalCode;
    }
    @Override
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }
    @Override
    public String getCity() {
        return city;
    }
    @Override
    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public ICPR getCpr() {
        return this.cpr;
    }

    @Override
    public long getCprNumber() {
        return this.cpr.getCprNumber();
    }

}
