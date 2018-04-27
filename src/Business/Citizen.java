package Business;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author goope
 */
public class Citizen {
    
    private int cprNumber;
    private String firstname;
    private String surname;
    private String roadName;
    private String houseNumber;
    private String floor;
    private int postNumber;
    private String city;
    private String tlfNumber;
    
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
        
        CPR cpr = new CPR(cprNumber);
    }
}
