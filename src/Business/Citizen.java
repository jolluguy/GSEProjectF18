package Business;

import Acquaintance.ICPR;
import Acquaintance.ICitizen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author goope
 */
public class Citizen implements ICitizen{
    
    private String firstName;
    private String lastName;
    private String roadName;
    private String houseNumber;
    private String floor;
    private int postalCode;
    private String city;
    private String phoneNumber;
    
    private ICPR cpr;
    
    Citizen (String cprNumber, String firstName, String lastName, String roadName, String houseNumber, String floor, int postalCode, String city, String phoneNumber) {
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

    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public void setRoadName(String roadName) {
        this.roadName = roadName;
    }

    @Override
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
