package Business;

import Acquaintance.IPerson;
import Acquaintance.IRepresentation;

/**
 *
 * @author Rasmus
 */
class Representation extends Person implements IRepresentation {

    private String representationType;
    private IPerson person;

    Representation(String cprNumber, String firstName, String lastName, String roadName, String houseNumber, String floor, int postalCode, String city, String phoneNumber, String representationType) {
        super(cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
        this.representationType = representationType;
        
        this.person = new Person(cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber) {};
    }

    @Override
    public String getRepresentationType() {
        return this.representationType;
    }

    
    @Override
    public IPerson getPerson(){
        return this.person;
    }
    
    
}

