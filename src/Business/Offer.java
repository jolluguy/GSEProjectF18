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

    Offer(int offerID, String offerSting) {
        this.offerID = offerID;
        this.offerDescription = offerSting;
    }

      public int getOfferID() {
        return offerID;
    }

    public String getOfferDescription() {
        return offerDescription;
    }
    
    
}
