package DataPersistence;

import Acquaintance.ICitizen;
import Acquaintance.IRepresentation;

public class DataRepresentation implements IRepresentation {
    private ICitizen citizen;
    private String representationType;

    
    DataRepresentation(String cprNumber, String firstName, String lastName, String roadName, String houseNumber, String floor, int postalCode, String city, String phoneNumber, String representationType) {
        this.citizen = new DataCitizen(cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
        this.representationType = representationType;
    }
    
    @Override
    public ICitizen getCitizen() {
        return this.citizen;
    }

    @Override
    public String getRepresentationType() {
        return this.representationType;
    }
}