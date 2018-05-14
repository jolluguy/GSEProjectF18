/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.ICase;
import Acquaintance.IInquiry;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.Date;

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
    public boolean createInquiry(String cprNumber, String problemDescription, String firstName, String lastName, String roadName, String houseNumber, String floor, int postalCode, String city, String phoneNumber) {
        Inquiry inquiry = new Inquiry(cprNumber, problemDescription, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
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
     boolean createCase(String cprNumber, String problemDescription, String firstName, String lastName, String roadName, String houseNumber, String floor, int postalCode, String city, String phoneNumber,
                Collection<String> responsibleCaseworkerIDList,
                Date meetingDate, Collection<String> attendingCasworkerIDList, String meetingDescription, String meetingLocation,
                String cprNumberRep, String firstNameRep, String lastNameRep, String roadNameRep, String houseNumberRep, String floorRep, int postalCodeRep, String cityRep, String phoneNumberRep, String representationType,
                String note, String caseWorkerID,
                Collection<Integer> serviceIDList,
                Collection<Integer> offerIDList){
       IInquiry inquiry = new Inquiry(cprNumber, problemDescription, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
       ICase case1 = new Case(inquiry, responsibleCaseworkerIDList, meetingDate, attendingCasworkerIDList, meetingDescription, meetingLocation, cprNumberRep, firstNameRep, lastNameRep, roadNameRep, houseNumberRep, floorRep, postalCodeRep, cityRep, phoneNumberRep, representationType, note, caseWorkerID, serviceIDList, offerIDList);
        
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
               
            
        } catch (Exception e) {     // to cathc array aout of bound exeptions and the like and return them as false cprNumbers
            return false;
        }   
}
}
