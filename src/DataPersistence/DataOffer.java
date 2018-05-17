package DataPersistence;

import Acquaintance.IOffer;

public class DataOffer implements IOffer {
    private int offerID;
    private String offerDescription;

    
    DataOffer(int offerID, String offerDescription) {
        this.offerID = offerID;
        this.offerDescription = offerDescription;
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