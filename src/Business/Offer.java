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
    
    private int offerID;
    private String offerDescription;

    Offer(int offerID, String offerSting) {
        this.offerID = offerID;
        this.offerDescription = offerSting;
    }

    @Override
      public int getOfferID() {
        return this.offerID;
    }

    @Override
    public String getOfferDescription() {
        return this.offerDescription;
    }
    
    
}
