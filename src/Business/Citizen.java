package Business;

import Acquaintance.ICPR;
import Acquaintance.ICitizen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author goope
 */
class Citizen extends Person implements ICitizen{

    Citizen(String cprNumber, String firstName, String lastName, String roadName, String houseNumber, String floor, int postalCode, String city, String phoneNumber) {
        super(cprNumber, firstName, lastName, roadName, houseNumber, floor, postalCode, city, phoneNumber);
    }
}