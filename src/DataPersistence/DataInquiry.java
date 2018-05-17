/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPersistence;

import Acquaintance.ICitizen;
import Acquaintance.IInquiry;
import java.sql.Timestamp;

/**
 *
 * @author Rasmus
 */
public class DataInquiry implements IInquiry {

    private String problemDescription;
    private String inquirer;
    private boolean citizenAgreement;
    private Timestamp time;
    private ICitizen citizen;
    
    
    //For getters, with regards to the constructor for the inquiry from the database
    private String concatenatedAddress;
    private String firstName;
    private String lastName;
    private String cprNumber;
    private String phoneNumber;
    
    
    //The standard constructor for making a DataInquiry
    public DataInquiry (String problemDescription, String inquirer, boolean citizenAgreement, String cprNumber, String firstName, 
            String lastName, String roadName, String houseNumber, String floor, 
            int postalCode, String city, String phoneNumber) {
        
        this.problemDescription = problemDescription;
        this.inquirer = inquirer;
        this.citizenAgreement = citizenAgreement;
        this.time = new Timestamp(System.currentTimeMillis());
        
        this.citizen = new DataCitizen(cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
    }
    //Contructor for when the inquiry comes from the database
    public DataInquiry (String problemDescription, String inquirer, boolean citizenAgreement, String cprNumber, String firstName, 
            String lastName, String address, String phoneNumber, Timestamp date) {
        
        this.problemDescription = problemDescription;
        this.inquirer = inquirer;
        this.citizenAgreement = citizenAgreement;
        this.time = date;
        //this.citizen = new DataCitizen(cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
        
        this.concatenatedAddress = address;
        this.cprNumber = cprNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        }

    @Override
    public ICitizen getCitizen() {
        return this.citizen;
    }

    @Override
    public void setCitizen(ICitizen citizen) {
        this.citizen = new DataCitizen(citizen.getCprNumber(), citizen.getFirstName(), citizen.getLastName(), citizen.getRoadName(), citizen.getHouseNumber(), citizen.getFloor(), citizen.getPostalCode(), citizen.getCity(), citizen.getPhoneNumber());
    }

    @Override
    public String getProblemDescription() {
        return this.problemDescription;
    }

    @Override
    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    @Override
    public String getInquirer() {
        return this.inquirer;
    }

    @Override
    public boolean getCitizenAgreement() {
        return this.citizenAgreement;
    }

    @Override
    public Timestamp getTime() {
        return this.time;
    }
    
    
    
    public String getConcatenatedAddress(){
        return this.concatenatedAddress;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getCPRNumber(){
        return cprNumber;
    }
}
