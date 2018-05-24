package DataPersistence;

import Acquaintance.ICitizen;
import Acquaintance.IPerson;
import Acquaintance.IRepresentation;

class DataRepresentation extends DataPerson implements IRepresentation {

    private String representationType;
    private IPerson person;

    
    DataRepresentation(String cprNumber, String firstName, String lastName, String roadName, String houseNumber, String floor, int postalCode, String city, String phoneNumber, String representationType) {
        super(cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
        this.representationType = representationType;
        
        this.person = new DataPerson(cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
    }
    

    @Override
    public String getRepresentationType() {
        return this.representationType;
    }
    
    
    @Override
    public IPerson getPerson(){
        return person;
    }
}