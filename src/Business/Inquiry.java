package Business;

import Acquaintance.ICitizen;
import Acquaintance.IInquiry;
import java.sql.Timestamp;

/**
 *
 * @author goope
 */
class Inquiry implements IInquiry{
    
    private String problemDescription;
    private String inquirer;
    private boolean citizenAgreement;
    private Timestamp time;
    private ICitizen citizen;
    private String responsibleCaseWorkerDomainID;
    
    Inquiry (String problemDescription, String inquirer, boolean citizenAgreement, String cprNumber, String firstName, 
            String lastName, String roadName, String houseNumber, String floor, 
            int postalCode, String city, String phoneNumber, String casworkerDomainId) {
        
        this.problemDescription = problemDescription;
        this.inquirer = inquirer;
        this.citizenAgreement = citizenAgreement;
        this.time = new Timestamp(System.currentTimeMillis());
        this.responsibleCaseWorkerDomainID = casworkerDomainId;
        
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

    @Override
    public String getResponsibleCaseWorkerDomainID() {
        return responsibleCaseWorkerDomainID;
    }
}
