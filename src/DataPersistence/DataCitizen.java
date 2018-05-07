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

    private String firstname;
    private String surname;
    private String roadName;
    private String houseNumber;
    private String floor;
    private int postNumber;
    private String city;
    private String tlfNumber;
    private ICPR cpr;

    public DataCitizen(long cprNumber, String firstname, String surname, String roadName, String houseNumber, String floor, int postNumber, String city, String tlfNumber) {
        this.firstname = firstname;
        this.surname = surname;
        this.roadName = roadName;
        this.houseNumber = houseNumber;
        this.floor = floor;
        this.postNumber = postNumber;
        this.city = city;
        this.tlfNumber = tlfNumber;
        
        this.cpr = new DataCPR(cprNumber);
    }

    
@Override
    public String getFirstname() {
        return firstname;
    }
    @Override
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    @Override
    public String getSurname() {
        return surname;
    }
    @Override
    public void setSurname(String surname) {
        this.surname = surname;
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
    public int getPostNumber() {
        return postNumber;
    }
    @Override
    public void setPostNumber(int postNumber) {
        this.postNumber = postNumber;
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
    public String getTlfNumber() {
        return tlfNumber;
    }

    @Override
    public void setTlfNumber(String tlfNumber) {
        this.tlfNumber = tlfNumber;
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
