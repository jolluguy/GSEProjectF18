/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IInquiry;

/**
 *
 * @author goope
 */
public class BusinessManager {    
    
    BusinessFacade facade = BusinessFacade.getInstance();
    
    private static BusinessManager instance = null;

    private BusinessManager() {
        
    }
    
    public static BusinessManager getInstance() {
        if (instance == null) {
            instance = new BusinessManager();
        }
        return instance;
    }
    
    public boolean createInquiry(long cprNumber, String problemDescription, String firstName, String lastName, String roadName, String houseNumber, String floor, int postalCode, String city, String phoneNumber) {
        Inquiry inquiry = new Inquiry(cprNumber, problemDescription, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
        if (!inquiry.getCitizen().getCpr().validateCPR()) {
            return false;
        }
        return sendToDB(inquiry);
    }

    // Kan vi sørge for at denne metode kan bruges til at gemme både Inquiry og Case, nu hvor de arver?
    public boolean sendToDB(IInquiry inquiry) {
        boolean returnMessage;
        
        returnMessage = facade.saveInq(inquiry);
        
        if (!returnMessage) {

            // Display errormessage (snak med GUI)
            while (!returnMessage) {
                //returnMessage = facade.saveInq(inquiry);
            }

            // Remove errormessage (snak med GUI)
        }
        return true;
    }    
}
