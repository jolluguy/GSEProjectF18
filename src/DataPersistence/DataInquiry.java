/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPersistence;

import Acquaintance.ICPR;
import Acquaintance.ICitizen;
import Acquaintance.IInquiry;
import java.sql.Timestamp;

/**
 *
 * @author Rasmus
 */
public class DataInquiry implements IInquiry {

    private ICitizen citizen;
    private String problemDescription;
    private String inquierer;
    private boolean citizenAgreement;
    Timestamp date;

    public DataInquiry(DataCitizen citizen, String problemDescription, String inquierer, boolean citizenAgreement, Timestamp date) {
        this.citizen = citizen;
        this.problemDescription = problemDescription;
        this.inquierer = inquierer;
        this.citizenAgreement = citizenAgreement;
        
        this.date = date;
    }

    @Override
    public ICitizen getCitizen() {
        return citizen;
    }

    @Override
    public void setCitizen(ICitizen citizen) {
        this.citizen = new DataCitizen(citizen.getCprNumber(), citizen.getFirstName(), citizen.getLastName(), citizen.getRoadName(), citizen.getHouseNumber(), citizen.getFloor(), citizen.getPostalCode(), citizen.getCity(), citizen.getPhoneNumber());
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
