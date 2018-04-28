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
    
    private int cprNumber;
    private String firstname;
    private String surname;
    private String roadName;
    private String houseNumber;
    private String floor;
    private int postNumber;
    private String city;
    private String tlfNumber;
    
    private CPR cpr;
    
    Citizen (int cprNumber, String firstname, String surname, String roadName, String houseNumber, String floor, int postNumber, String city, String tlfNumber) {
        this.cprNumber = cprNumber;
        this.firstname = firstname;
        this.surname = surname;
        this.roadName = roadName;
        this.houseNumber = houseNumber;
        this.floor = floor;
        this.postNumber = postNumber;
        this.city = city;
        this.tlfNumber = tlfNumber;
        
        cpr = new CPR(cprNumber);
    }

    public int getCprNumber() {
        return cprNumber;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getRoadName() {
        return roadName;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getFloor() {
        return floor;
    }

    public int getPostNumber() {
        return postNumber;
    }

    public String getCity() {
        return city;
    }

    public String getTlfNumber() {
        return tlfNumber;
    }

    public CPR getCpr() {
        return cpr;
    }

    @Override
    public void setFirstname(String firstname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSurname(String surname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setRoadName(String roadName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setHouseNumber(String houseNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setFloor(String floor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPostNumber(int postNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setCity(String city) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setTlfNumber(String tlfNumber) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
