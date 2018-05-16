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
    private String inquierer;
    private boolean citizenAgreement;
    Timestamp date;
    private ICitizen citizen;
    
    public Inquiry (String problemDescription, String inquierer, boolean citizenAgreement, String cprNumber, String firstName, 
            String lastName, String roadName, String houseNumber, String floor, 
            int postalCode, String city, String phoneNumber) {
        
        this.problemDescription = problemDescription;
        this.inquierer = inquierer;
        this.citizenAgreement = citizenAgreement;
        this.date = new Timestamp(System.currentTimeMillis());
        
        citizen = new Citizen(cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
    }

   
    @Override
    public ICitizen getCitizen() {
        return citizen;
    }

    @Override
    public void setCitizen(ICitizen citizen) {
        this.citizen = citizen;
    }

    @Override
    public String getProblemDescription() {
        return problemDescription;
    }

    @Override
    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    @Override
    public String getInquierer() {
        return this.inquierer;
    }

    @Override
    public boolean getCitizenAgreement() {
        return this.citizenAgreement;
    }

    @Override
    public Timestamp getDate() {
        return this.date;
    }
    
}
