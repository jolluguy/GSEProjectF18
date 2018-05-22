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
    private String responsibleCaseworkerID;

    public DataInquiry (String problemDescription, String inquirer, boolean citizenAgreement, String cprNumber, String firstName, 
            String lastName, String roadName, String houseNumber, String floor, 
            int postalCode, String city, String phoneNumber, String responsibleCaseworkerID) {
        
        this.problemDescription = problemDescription;
        this.inquirer = inquirer;
        this.citizenAgreement = citizenAgreement;
        this.time = new Timestamp(System.currentTimeMillis());
        this.responsibleCaseworkerID = responsibleCaseworkerID;
        
        this.citizen = new DataCitizen(cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
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

    @Override
    public String getResponsibleCaseWorkerDomainID() {
       return this.responsibleCaseworkerID;
    }
}