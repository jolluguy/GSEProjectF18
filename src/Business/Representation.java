package Business;


import Acquaintance.IRepresentation;

/**
 *
 * @author Rasmus
 */
public class Representation extends Person implements IRepresentation{


    private String representationType;

    public Representation(String cprNumber, String firstName, String lastName, String roadName, String houseNumber, String floor, int postalCode, String city, String phoneNumber, String representationType) {
        super(cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
        this.representationType = representationType;
    }
    
    
    //implementer get og set representationstype

   

    @Override
    public String getRepresentationType() {
        return this.representationType;
    }
}