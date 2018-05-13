/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Acquaintance.ICitizen;
import Acquaintance.IRepresentation;

/**
 *
 * @author Rasmus
 */
public class Representation implements IRepresentation{

    ICitizen citizen;
    String representationType;

    public Representation(String cprNumber, String firstName, String lastName, String roadName, String houseNumber, String floor, int postalCode, String city, String phoneNumber, String representationType) {
        this.citizen = new Citizen(cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
        this.representationType = representationType;
    }
    
}
