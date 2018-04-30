/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPersistens;

import Acquaintance.ICPR;
import Acquaintance.ICitizen;
import Acquaintance.IInquiry;

/**
 *
 * @author Rasmus
 */
public class DataInquiry implements IInquiry {

    private DataCPR cpr;
    private DataCitizen citizen;
    private String problemDescription;

    public DataInquiry(DataCitizen citizen, String problemDescription) {
        this.cpr = cpr;
        this.citizen = citizen;
        this.problemDescription = problemDescription;
    }

    @Override
    public ICPR getCpr() {
        return cpr;
    }

    @Override
    public void setCpr(ICPR cpr) {
        this.cpr = new DataCPR(cpr.getCprNumber());
    }

    @Override
    public ICitizen getCitizen() {
        return citizen;
    }

    @Override
    public void setCitizen(ICitizen citizen) {
        this.citizen = new DataCitizen(citizen.getCprNumber(), citizen.getFirstname(), citizen.getSurname(), citizen.getRoadName(), citizen.getHouseNumber(), citizen.getFloor(), citizen.getPostNumber(), citizen.getCity(), citizen.getTlfNumber());
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
