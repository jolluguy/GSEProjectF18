/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.ICPR;
import Acquaintance.ICitizen;
import Acquaintance.IInquiry;

/**
 *
 * @author goope
 */
public class Inquiry implements IInquiry{
    
    private String problemDescription;
    private ICitizen citizen;
    
    Inquiry (long cprNumber, String problemDescription, String firstname, String surname, String roadName, String houseNumber, String floor, int postNumber, String city, String tlfNumber) {
        this.problemDescription = problemDescription;
        
        citizen = new Citizen(cprNumber, firstname, surname, roadName, houseNumber, floor, postNumber, city, tlfNumber);
    }

    @Override
    public ICPR getCpr() {
        return citizen.getCpr();
    }

    @Override
    public void setCpr(ICPR cpr) {
        this.citizen.setCpr(cpr);
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
    
}
