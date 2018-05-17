/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.ICitizen;
import Acquaintance.IInquiry;
import java.sql.Timestamp;

/**
 *
 * @author goope
 */
public class Inquiry implements IInquiry{
    
    private String problemDescription;
    private String inquirer;
    private boolean citizenAgreement;
    private Timestamp time;
    private ICitizen citizen;
    
    
    //Normal Inquiry constructor
    public Inquiry (String problemDescription, String inquirer, boolean citizenAgreement, String cprNumber, String firstName, 
            String lastName, String roadName, String houseNumber, String floor, 
            int postalCode, String city, String phoneNumber) {
        
        this.problemDescription = problemDescription;
        this.inquirer = inquirer;
        this.citizenAgreement = citizenAgreement;
        this.time = new Timestamp(System.currentTimeMillis());
        
        this.citizen = new Citizen(cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
    }

    //Inquiry constructor for when it comes from the database
    public Inquiry (String problemDescription, String inquirer, boolean citizenAgreement, String cprNumber, String firstName, 
            String lastName, String roadName, String houseNumber, String floor, 
            int postalCode, String city, String phoneNumber, Timestamp date) {
        
        this.problemDescription = problemDescription;
        this.inquirer = inquirer;
        this.citizenAgreement = citizenAgreement;
        this.time = date;
        
        this.citizen = new Citizen(cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
    }
    
   
    @Override
    public ICitizen getCitizen() {
        return this.citizen;
    }

    @Override
    public void setCitizen(ICitizen citizen) {
        this.citizen = citizen;
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
}
