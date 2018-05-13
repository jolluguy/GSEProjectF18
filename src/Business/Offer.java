/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.IOffer;

/**
 *
 * @author Rasmus
 */
class Offer implements IOffer {
    
    int offerID;
    String offerDescription;

    Offer(int offerID) {
        this.offerID = offerID;
        this.offerDescription = getOfferDescription(offerID);
    }

    private String getOfferDescription(int offerID) {
        throw new UnsupportedOperationException("Not supported yet."); // incert code here that take the service id and returns the offer id from wherever it is stored.... maby a hashmap???? make catalouge class again?
    }

    public int getOfferID() {
        return offerID;
    }

    public String getOfferDescription() {
        return offerDescription;
    }
    
    
}
