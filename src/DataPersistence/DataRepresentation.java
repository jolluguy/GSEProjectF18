package DataPersistence;

import Acquaintance.ICitizen;
import Acquaintance.IRepresentation;

public class DataRepresentation extends DataPerson implements IRepresentation {

    private String representationType;

    
    DataRepresentation(String cprNumber, String firstName, String lastName, String roadName, String houseNumber, String floor, int postalCode, String city, String phoneNumber, String representationType) {
        super(cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
        this.representationType = representationType;
    }
    

    @Override
    public String getRepresentationType() {
        return this.representationType;
    }
}