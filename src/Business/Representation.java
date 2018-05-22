package Business;

import Acquaintance.IRepresentation;

/**
 *
 * @author Rasmus
 */
class Representation extends Person implements IRepresentation {

    private String representationType;

    Representation(String cprNumber, String firstName, String lastName, String roadName, String houseNumber, String floor, int postalCode, String city, String phoneNumber, String representationType) {
        super(cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
        this.representationType = representationType;
    }

    @Override
    public String getRepresentationType() {
        return this.representationType;
    }
}
