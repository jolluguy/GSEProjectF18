/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;


import Acquaintance.IRepresentation;

/**
 *
 * @author Rasmus
 */
public class Representation extends Person implements IRepresentation{


    String representationType;

    public Representation(String cprNumber, String firstName, String lastName, String roadName, String houseNumber, String floor, int postalCode, String city, String phoneNumber, String representationType) {
        super(cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
        this.representationType = representationType;
    }
    
    
    //implementer get og set representationstype

   

    @Override
    public String getRepresentationType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }
    
