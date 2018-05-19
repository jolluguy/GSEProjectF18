package Business;

import Acquaintance.ICase;
import Acquaintance.IInquiry;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author goope
 */
public class CaseManager {    
    
    BusinessFacade facade = BusinessFacade.getInstance();
    
    private static CaseManager instance = null;

    private CaseManager() {
        
    }
    
    public static CaseManager getInstance() {
        if (instance == null) {
            instance = new CaseManager();
        }
        return instance;
    }
    
    /**
     * used to create an Inquiry and saving it in the database
     * @param cprNumber
     * @param problemDescription
     * @param firstName
     * @param lastName
     * @param roadName
     * @param houseNumber
     * @param floor
     * @param postalCode
     * @param city
     * @param phoneNumber
     * @return 
     */
    public boolean createInquiry(String problemDescription, String inquirer, boolean citizenAgreement, String cprNumber, String firstName, 
            String lastName, String roadName, String houseNumber, String floor, 
            int postalCode, String city, String phoneNumber) {
        Inquiry inquiry = new Inquiry(problemDescription, inquirer, citizenAgreement, cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
        return sendInqToDB(inquiry);
    }

    /**
     * method used to save a inquiry to the db, is called in createInquiry()
     * @param inquiry
     * @return 
     */
    private boolean sendInqToDB(IInquiry inquiry) {
        boolean returnMessage;
        
        returnMessage = facade.saveInq(inquiry);
        
        if (!returnMessage) {

            // Display errormessage (snak med GUI)
            while (!returnMessage) {
                //returnMessage = facade.saveInq(inquiry);
            }

            // Remove errormessage (snak med GUI)
        }
        return returnMessage;
    }
    
    /**
     * Method for creating a new case in the system. it alsows cals on a method that saves the case in the db when it is created
     * @param cprNumber
     * @param problemDescription
     * @param firstName
     * @param lastName
     * @param roadName
     * @param houseNumber
     * @param floor
     * @param postalCode
     * @param city
     * @param phoneNumber
     * @param responsibleCaseworkerIDList
     * @param meetingDate
     * @param attendingCasworkerIDList
     * @param meetingDescription
     * @param meetingLocation
     * @param cprNumberRep
     * @param firstNameRep
     * @param lastNameRep
     * @param roadNameRep
     * @param houseNumberRep
     * @param floorRep
     * @param postalCodeRep
     * @param cityRep
     * @param phoneNumberRep
     * @param representationType
     * @param note
     * @param caseWorkerID
     * @param serviceIDList
     * @param offerIDList
     * @return 
     */
     boolean createCase(String problemDescription, String inquirer, boolean citizenAgreement, String cprNumber, String firstName, String lastName, String roadName, String houseNumber, String floor, int postalCode, String city, String phoneNumber,
                String responsibleCaseworker, boolean informedRightsBystander, boolean informedRightsElectronicRegistration, String consent, Collection<String> consentToInformationGathering, String specialCircumstances, String otherActingMunicipality, String otherPayingMunicipality,
                Timestamp meetingDate, Collection<String> attendingCasworkerIDList, String meetingDescription, String meetingLocation,
                String cprNumberRep, String firstNameRep, String lastNameRep, String roadNameRep, String houseNumberRep, String floorRep, int postalCodeRep, String cityRep, String phoneNumberRep, String representationType,
                String note, String caseWorkerID,
                Map<Integer, String> serviceIDList,
                Map<Integer, String> offerIDList){
       IInquiry inquiry = new Inquiry(problemDescription, inquirer, citizenAgreement, cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
       ICase case1 = new Case(inquiry, responsibleCaseworker,  informedRightsBystander,  informedRightsElectronicRegistration,  consent, consentToInformationGathering, specialCircumstances, otherActingMunicipality, otherPayingMunicipality, meetingDate, attendingCasworkerIDList, meetingDescription, meetingLocation, cprNumberRep, firstNameRep, lastNameRep, roadNameRep, houseNumberRep, floorRep, postalCodeRep, cityRep, phoneNumberRep, representationType, note, caseWorkerID, serviceIDList, offerIDList);
        
        return sendCaseToDB(case1);
       }

    private boolean sendCaseToDB(ICase case1) {
            boolean returnMessage;
        
        returnMessage = facade.saveCase(case1);
        
        if (!returnMessage) {

            // Display errormessage (snak med GUI)
            while (!returnMessage) {
                //returnMessage = facade.saveInq(inquiry);
            }

            // Remove errormessage (snak med GUI)
        }
        return returnMessage;
    }
    public boolean validateCPR(String cprNumber) {
        try {
            String parts[] = cprNumber.split("-");
            String birthpart = parts[0];
            String securitypart = parts[1];
        
            return (birthpart.matches("^[0-9]{6}$") && securitypart.matches("^[0-9]{4}$"));         //matches is a predetermenind method for maching the charecters in a string, [0-9] defines a class that contains numbers from  0-9, the ^ indicates that the comparison must start at the end of the string, and the $ indicates that it must continue until the end, the part [0-9]{x} indikates that its only tru if it ran throug exaxtly x charecters and all of them was a number btween 0-9.
               
            
        } catch (Exception e) {     // to cathc array out of bounds exeptions and the like, and return them as false cprNumbers
            return false;
        }   
    }
}